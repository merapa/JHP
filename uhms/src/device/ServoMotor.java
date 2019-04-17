package device;

import com.pi4j.io.gpio.impl.GpioPinImpl;

public class ServoMotor extends GpioPinDevice {

	private GpioPinImpl[] pins = null;
	private String deviceId = null;
	
	@Override
	public void init(GpioPinImpl pin) {
		this.pins = new GpioPinImpl[1];
	}

	@Override
	public void init(GpioPinImpl[] pins) {
		this.pins = new GpioPinImpl[pins.length];
	}

	@Override
	public void runDevice(Object value) {
		int pwm_value = (int)value;
		if(pwm_value < 5) {
			pwm_value = 5;
		}
		if(pwm_value > 25) {
			pwm_value = 25;
		}
		for(int i=0; i<this.pins.length; i++) {
			this.pins[i].setPwm(pwm_value);
		}
	}

	@Override
	public void stopDevice() {
		for(int i=0; i<this.pins.length; i++) {
			this.pins[i].setPwm(5);
		}
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	
	
	
}
