package device;

import com.pi4j.io.gpio.impl.GpioPinImpl;

public class StepperMotor extends GpioPinDevice {

	private GpioPinImpl[] pins = null;
	private String deviceId = null;
	private int[][] rotateRData = {
			{1,0,0,0},
			{0,1,0,0},
			{0,0,1,0},
			{0,0,0,1}
	};
	private int[][] rotateLData = {
			{0,0,0,1},
			{0,0,1,0},
			{0,1,0,0},
			{1,0,0,0}
	};
	
	@Override
	public void init(GpioPinImpl pin) {
		this.pins = new GpioPinImpl[1];
		this.pins[0] = pin;
	}

	@Override
	public void init(GpioPinImpl[] pins) {
		this.pins = new GpioPinImpl[pins.length];
		for(int i=0; i<pins.length; i++) {
			this.pins[i] = pins[i];
		}
	}

	@Override
	public void runDevice(Object value) {
		if((int)value > 0) {
			this.rotateR((int)value);
		} else if((int) value < 0) {
			this.rotateL((int)value);
		} else {
			this.stopDevice();
		}
	}

	@Override
	public void stopDevice() {
		try {
			this.phaseState(new int[]{0,0,0,0}, 10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	private void rotateR(int step) {
		try {
			for(int i=0; i<step; i++) {
				this.phaseState(this.rotateRData[i], 10);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	}
	
	private void rotateL(int step) {
		try {
			for(int i=0; i<step; i++) {
				this.phaseState(this.rotateLData[i], 10);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
				}
	}

	private void phaseState(int[] data, int delay) throws InterruptedException {
		for(int i=0; i<data.length; i++) {
			if(data[i] > 0) {
				pins[i].high();
			} else {
				pins[i].low();
			}
		}
		Thread.sleep(delay);
	}
}
