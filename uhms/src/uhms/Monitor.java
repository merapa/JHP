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
		this.dm = new DeviceManager(this, this.ses);
	}

	public static void main(String[] args) {
		Monitor monitor = new Monitor();
		monitor.listView();
		monitor.chosenItem();
	}
	
	private void listView() {
		System.out.println();
		System.out.println("紐⑸줉");
		System.out.println("1. 濡쒓렇蹂닿린");
		System.out.println("2. �쁽�옱 �� �꽕�젙");
		System.out.println("3. 吏곸젒 �젣�뼱�븯湲�");
		System.out.println("4. �봽濡쒓렇�옩 醫낅즺");
		System.out.println();
	}
	
	private void chosenItem() {
		String line;
		Scanner scan = new Scanner(System.in);
		this.runbackgroundTask();
		while((line = scan.nextLine()) != null) {
			if(line.equals("1")) {
				System.out.println("1 異쒕젰");
			} else if (line.equals("2")) {
				System.out.println("2 異쒕젰");
			} else if (line.equals("3")) {
				System.out.println("3 異쒕젰");
			} else if (line.equals("4")) {
				break;
			} else {
				this.shutdown();
				break;
			}
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
		this.ses.submit(this.dm);
		this.ses.submit(this.nc);
	}
}
