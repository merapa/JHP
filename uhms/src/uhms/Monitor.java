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
		this.nc = new NetworkController(this, this.ses);
		this.dm = new DeviceManager(this, this.ses);
	}

	public static void main(String[] args) {
		Monitor monitor = new Monitor();
		monitor.listView();
		monitor.chosenItem();
	}
	
	private void listView() {
		System.out.println();
		System.out.println("목록");
		System.out.println("1. 로그보기");
		System.out.println("2. 현재 핀 설정");
		System.out.println("3. 직접 제어하기");
		System.out.println("4. 프로그램 종료");
		System.out.println();
	}
	
	private void chosenItem() {
		String line;
		Scanner scan = new Scanner(System.in);
		this.runbackgroundTask();
		while((line = scan.nextLine()) != null) {
			if(line.equals("1")) {
				System.out.println("1 출력");
			} else if (line.equals("2")) {
				System.out.println("2 출력");
			} else if (line.equals("3")) {
				System.out.println("3 출력");
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
