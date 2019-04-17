package device;

import com.pi4j.io.gpio.impl.GpioPinImpl;

public abstract class GpioPinDevice implements Operable {

	private GpioPinImpl[] pins = null;
	private String deviceId = null;
	
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
	
	@Override
	public void runDevice(Object value) {}

	@Override
	public void stopDevice() {}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	
	
}
