package jtest;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import uhms.Monitor;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MonitorTest {

	private static Monitor mo = null;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		mo = new Monitor();
	}

	@Test
	public void test1_ClassNullCheck() {
		System.out.println("test_1");
		assertNotNull(mo);
		assertNotNull(mo.getDeviceManager());
		assertNotNull(mo.getDeviceManager().getDeviceInfo());
		assertNotNull(mo.getScheduledExecutorService());
		assertNotNull(mo.getNetworkController());
		assertNotNull(mo.getNetworkController().getDc());
		assertNotNull(mo.getNetworkController().getSender());
		assertNotNull(mo.getNetworkController().getReceiver());
		System.out.println("test_1_end");
	}
	
	@Test
	public void test2_filesetting() {
		System.out.println("test_2");
		assertEquals("LED",mo.getDeviceManager().getDeviceInfo().getGpioPinDevice("LED").getDeviceId());
		assertEquals("COOLER",mo.getDeviceManager().getDeviceInfo().getGpioPinDevice("COOLER").getDeviceId());
		assertEquals("HEATER",mo.getDeviceManager().getDeviceInfo().getGpioPinDevice("HEATER").getDeviceId());
		assertEquals("SERVOMOTOR",mo.getDeviceManager().getDeviceInfo().getGpioPinDevice("SERVOMOTOR").getDeviceId());
		assertEquals("STEPPERMOTOR",mo.getDeviceManager().getDeviceInfo().getGpioPinDevice("STEPPERMOTOR").getDeviceId());
		assertEquals("MCP3008",mo.getDeviceManager().getDeviceInfo().getSpiPinDevice("MCP3008").getDeviceId());
		System.out.println("test_2_end");
	}
	
	//@Test
	public void test3_getAndSetValues() {
		System.out.println("test_3_start");
		mo.getDeviceManager().getDeviceInfo().getGpioPinDevice("LED").setValues(12);
		mo.getDeviceManager().getDeviceInfo().getGpioPinDevice("COOLER").setValues(1);
		mo.getDeviceManager().getDeviceInfo().getGpioPinDevice("HEATER").setValues(1);
		mo.getDeviceManager().getDeviceInfo().getGpioPinDevice("SERVOMOTOR").setValues(25);
		mo.getDeviceManager().getDeviceInfo().getGpioPinDevice("STEPPERMOTOR").setValues(90);
		mo.getDeviceManager().getDeviceInfo().getSpiPinDevice("MCP3008").initDatachannel(2,0,7);

		try {
			mo.getDeviceManager().generateGpioPinDevice("LED");
			mo.getDeviceManager().generateGpioPinDevice("COOLER");
			mo.getDeviceManager().generateGpioPinDevice("HEATER");
			mo.getDeviceManager().generateGpioPinDevice("SERVOMOTOR");
			mo.getDeviceManager().generateGpioPinDevice("STEPPERMOTOR");
			mo.getDeviceManager().generateSpiPinDevice("MCP3008");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("test_3_end");
	}
	
	//@Test
	public void test4_dbGetOperateData() throws SQLException, InterruptedException, ExecutionException {
		System.out.println("test_4_start");
//		String[] temp = mo.getNetworkController().getDc().getOperateData();
//		for(int i=0; i<temp.length; i++) {
//			System.out.print(" "+temp[i]+" ");
//		}
//		System.out.println();
		
		mo.getNetworkController().getDc().setMessage("getOperateData");
		Future<String[]> ftemp = mo.getScheduledExecutorService().submit(mo.getNetworkController().getDc());
		String[] stemp = ftemp.get();
		for(int i=0; i<stemp.length; i++) {
			System.out.print(" "+stemp[i]+" ");
		}
		System.out.println();
		System.out.println("test_4_end");
	}
	
	@Test(timeout = 4000)
	public void test5_dbUpToDataInDatabase() throws Exception {
		System.out.println("test_5_start");
		mo.getDeviceManager().getDeviceInfo().getSpiPinDevice("MCP3008").initDatachannel(2,0,7);
		mo.getDeviceManager().generateSpiPinDevice("MCP3008");
		int a = mo.getDeviceManager().getDeviceInfo().getSpiPinDevice("MCP3008").getData(0);
		int b = mo.getDeviceManager().getDeviceInfo().getSpiPinDevice("MCP3008").getData(7);
		mo.getNetworkController().getDc().setLevel(String.valueOf(a));
		mo.getNetworkController().getDc().setTemp(String.valueOf(b));
		mo.getNetworkController().getDc().upToDataInDatabase();
//		mo.getNetworkController().getDc().setMessage("upToData");
//		mo.getScheduledExecutorService().submit(mo.getNetworkController().getDc());
		System.out.println("test_5_end");
		
	}
	
	@Test
	public void test6_httpConnection() throws InterruptedException, ExecutionException {
		System.out.println("test_6_start");
		mo.getScheduledExecutorService().submit(mo.getNetworkController().getReceiver());
		System.out.println("test_6_end");
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		mo.shutdown();
	}

}
