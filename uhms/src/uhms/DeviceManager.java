package uhms;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import network.DBComunicator;

public class DeviceManager implements Runnable{
	
	private Monitor mo = null;
	private DeviceInfo di = null;
	private EcologicalEnvironment ee = null;
	private String[] command = null;
	
	public DeviceManager(Monitor mo, ScheduledExecutorService ses) {
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
		this.mo.getScheduledExecutorService().submit(this.di.getGpioPinDevice(command));
	}
	
	public void generateSpiPinDevice(String command) throws Exception {
		this.mo.getScheduledExecutorService().submit(this.di.getSpiPinDevice(command));
	}
	
	public Monitor getMo() {
		return mo;
	}

	public DeviceInfo getDeviceInfo() {
		return this.di;
	}
		
	public void setCommand(String[] command) {
		this.command = command;
	}

	public void shutdown() {
		this.di.shutdown();
	}

	@Override
	public void run() {
		while(true) {
			try{
				if(this.command != null){
					this.getDeviceInfo().getGpioPinDevice(this.command[0].toUpperCase()).setValues(Integer.parseInt(this.command[1]));
					this.generateGpioPinDevice(this.command[0].toUpperCase());
				} else if(this.command[0].toUpperCase().equals("EXIT")){
					break;
				}
				this.generateSpiPinDevice("MCP3008");
			} catch (Exception e) {
				e.printStackTrace();
				break;
			}
		}
	}
}
