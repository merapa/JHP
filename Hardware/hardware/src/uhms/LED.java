package uhms;

import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.Pin;

public class LED {
	private GpioPinDigitalOutput digitPin = null;
	
	public LED(Pin pin){
		digitPin = GpioFactory.getInstance().provisionDigitalOutputPin(pin);
	}
	
	public void turnOn() {
		digitPin.isHigh();
	}
	
	public void turnOff() {
		digitPin.isLow();
	}
}
