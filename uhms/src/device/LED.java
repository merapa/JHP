package device;

import com.pi4j.io.gpio.PinMode;
import com.pi4j.io.gpio.impl.GpioPinImpl;

public class LED extends GpioPinDevice {

	private GpioPinImpl[] pins = null;
	
	@Override
	public void init(GpioPinImpl pin) {
		this.pins = new GpioPinImpl[1];
		this.pins[0] = pin;
		this.pins[0].setMode(PinMode.SOFT_PWM_OUTPUT);
		this.pins[0].setPwmRange(100);
		this.pins[0].setPwm(0);
	}

	@Override
	public void init(GpioPinImpl[] pins) {
		this.pins = new GpioPinImpl[pins.length];
		for(int i=0; i<pins.length; i++) {
			this.pins[i] = pins[i];
			this.pins[i].setMode(PinMode.SOFT_PWM_OUTPUT);
			this.pins[i].setPwmRange(100);
			this.pins[i].setPwm(0);
		}
	}

	@Override
	public void runDevice(int value) {
		if(this.pins.length>0) {
			if(value > 100) {
				value = 100;
			} else if(value <0) {
				value = 0;
			}
			for(int i=0; i<this.pins.length; i++) {
				this.pins[i].setPwm(value);
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

	@Override
	public GpioPinImpl[] getPins() {
		return this.pins;
	}

	@Override
	public void run() {
		this.runDevice(this.getValues());
	}
}
