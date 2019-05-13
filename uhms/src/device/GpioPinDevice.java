package device;

import com.pi4j.io.gpio.impl.GpioPinImpl;

public abstract class GpioPinDevice implements Operable, Runnable {

	private GpioPinImpl[] pins = null;
	private String deviceId = null;
	private int values = 0;
	
	public void init(GpioPinImpl pin) {
		this.pins = new GpioPinImpl[1];
		this.pins[0] = pin;
	}
	
	public void init(GpioPinImpl[] pins) {
		this.pins = new GpioPinImpl[pins.length];
		for(int i=0; i<pins.length; i++) {
			this.pins[i] = pins[i];
		}
	}
	
	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	
	@Override
	public void runDevice(int value) {}

	@Override
	public void stopDevice() {}
	
	public abstract GpioPinImpl[] getPins();
	
	public int getValues() {
		return values;
	}

	public void setValues(int values) {
		this.values = values;
	}


}
