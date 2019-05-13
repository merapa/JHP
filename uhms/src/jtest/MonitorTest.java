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

	@Test
	public void test3_HttpServerTest() {
		assertNotNull(mo.getNetworkController().getReceiver());
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		mo.shutdown();
	}

}