package uhms;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import network.DBComunicator;

public class DeviceManager {
	
	private Monitor mo = null;
	private DeviceInfo di = null;
	private EcologicalEnvironment ee = null;
	
	public DeviceManager(Monitor mo) {
		this.mo = mo;
		this.di = new DeviceInfo("./config/deviceConfig");
		this.ee = new EcologicalEnvironment(this);
		
		DBComunicator dbc = this.mo.getNetworkController().getDc();
		dbc.setMessage("getOperateData");
		Future<String[]> temp = this.mo.getScheduledExecutorService().submit(this.mo.getNetworkController().getDc());
		String[] values = null;
		try {
			values = temp.get();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		this.ee.setLed_time(new String[]{values[1],values[2]});
		this.ee.setCooler_time(new int[]{Integer.parseInt(values[3].substring(0,2)),Integer.parseInt(values[4].substring(0,2))});
		this.ee.setHeater_time(new int[]{Integer.parseInt(values[5].substring(0,2)),Integer.parseInt(values[6].substring(0,2))});
		this.ee.setLevel_value(new int[]{Integer.parseInt(values[7].substring(0,2)),Integer.parseInt(values[8].substring(0,2))});
		this.ee.setFeedtime(new String[]{values[9],values[10]});
	}
	
	public void generateGpioPinDevice(String command) throws Exception {
		this.mo.getScheduledExecutorService().execute(this.di.getGpioPinDevice(command));
	}
	
	public void generateSpiPinDevice(String command) throws Exception {
		this.mo.getScheduledExecutorService().execute(this.di.getSpiPinDevice(command));
	}
	
	public Monitor getMo() {
		return mo;
	}

	public DeviceInfo getDeviceInfo() {
		return this.di;
	}
		
	public void shutdown() {
		this.di.shutdown();
	}

}
