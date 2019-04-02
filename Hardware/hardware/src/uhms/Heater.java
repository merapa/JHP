package uhms;

import com.pi4j.io.gpio.GpioPinDigitalOutput;

public class Heater {
	
	private GpioPinDigitalOutput digitPin = null;

	public void turnOn() {
		digitPin.isHigh();
	}
	
	public void turnOff() {
		digitPin.isLow();
	}
}
