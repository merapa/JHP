package device;

import com.pi4j.io.gpio.impl.GpioPinImpl;

public class LED extends GpioPinDevice {

	private GpioPinImpl[] pins = null;
	private String deviceId = null;
	
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
		if(this.pins.length>0) {
			for(int i=0; i<this.pins.length; i++) {
				this.pins[i].setPwm((int)value);
			}
		}
	}

	@Override
	public void stopDevice() {
		if(this.pins.length > 0) {
			for(int i=0; i<this.pins.length; i++) {
				this.pins[i].setPwm(0);
			}
		}
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
}
