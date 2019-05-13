package uhms;

import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import network.NetworkController;

public class Monitor {

	private ScheduledExecutorService ses = null;
	private DeviceManager dm = null;
	private NetworkController nc = null;
	
	public Monitor() {
		this.ses = Executors.newScheduledThreadPool(10);
		this.nc = new NetworkController(this);
		this.dm = new DeviceManager(this);
	}

	public static void main(String[] args) throws Exception {
		Monitor monitor = new Monitor();
		monitor.listView();
		monitor.chosenItem();
		monitor.shutdown();
	}
	
	private void listView() {
		System.out.println();
		System.out.println("Command List(input number, not white space, only one character)");
		System.out.println("1. generateGpioPinHardware");
		System.out.println("2. generateSpiPinHardware");
		System.out.println("other character : exit");
	}
	
	private void chosenItem() throws Exception {
		String line;
		Scanner scan = new Scanner(System.in);
		this.runbackgroundTask();
		while((line = scan.nextLine()) != null) {
			if(line.equals("1")) {
				System.out.println("기기 : 값");
				String[] lines = scan.nextLine().split("\\s");
				this.dm.getDeviceInfo().getGpioPinDevice(lines[0]).setValues(Integer.parseInt(lines[1]));
				this.dm.generateGpioPinDevice(lines[0].toUpperCase());
			} else if(line.equals("2")) {
				System.out.println("기기");
				line = scan.nextLine();
				this.dm.generateSpiPinDevice(line.toUpperCase());
				int[] temp = this.dm.getDeviceInfo().getSpiPinDevice(line.toUpperCase()).getchannel();
				for(int i=0; i<temp.length; i++) {
						System.out.print(temp[i]+"   ");
				}
			} else {
				System.out.println("end");
				break;
			}
			this.listView();
		}
		scan.close();
	}

	public ScheduledExecutorService getScheduledExecutorService() {
		return ses;
	}

	public DeviceManager getDeviceManager() {
		return dm;
	}

	public NetworkController getNetworkController() {
		return nc;
	}
	
	public void shutdown() {
		this.dm.shutdown();
		this.ses.shutdown();
	}
	
	private void runbackgroundTask() {
		
	}
}
