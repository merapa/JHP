package device;

import com.pi4j.io.gpio.PinMode;
import com.pi4j.io.gpio.impl.GpioPinImpl;

public class ServoMotor extends GpioPinDevice {

	private GpioPinImpl[] pins = null;
	
	@Override
	public void init(GpioPinImpl pin) {
		this.pins = new GpioPinImpl[1];
		this.pins[0] = pin;
		this.pins[0].setMode(PinMode.SOFT_PWM_OUTPUT);
		this.pins[0].setPwmRange(100);
		this.pins[0].setName(pin.getPin().getAddress()+"Soft_Pwm_OutPut");
		this.pins[0].setProperty("Allocated_Naming_0", "0");
		this.pins[0].setTag("Pin_"+pin.getPin().getAddress());
		this.pins[0].setPwm(5);
	}

	@Override
	public void init(GpioPinImpl[] pins) {
		this.pins = new GpioPinImpl[pins.length];
		for(int i=0; i<pins.length; i++) {
			this.pins[i] = pins[i];
			this.pins[i].setMode(PinMode.SOFT_PWM_OUTPUT);
			this.pins[i].setPwmRange(128);
			this.pins[i].setName(pins[i].getPin().getAddress()+"Soft_Pwm_OutPut");
			this.pins[i].setProperty("Allocated_Naming_"+i, String.valueOf(i));
			this.pins[i].setTag("Pin_"+pins[i].getPin().getAddress());
			this.pins[i].setPwm(5);
		}
	}

	@Override
	public void runDevice(int value) {
		int pwm_value = value;
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

	@Override
	public GpioPinImpl[] getPins() {
		return this.pins;
	}

	
	@Override
	public void run() {
		this.runDevice(super.getValues());
	}
}
