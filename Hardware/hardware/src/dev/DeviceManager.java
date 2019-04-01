package dev;

public class DeviceManager {

	public DeviceManager() {
	}

	private DeviceInfo[] deviceInfo;

	public static void main() {
		
	}

	public void initDevice() {
		this.deviceInfo = new DeviceInfo[5];
		for(int i=0; i<5; i++) {
			this.deviceInfo[i] = new DeviceInfo();
		}
	}

	public void commandOperate(int index, int[] ectParam) {
		
	}

}