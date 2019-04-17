package device;

import com.pi4j.io.gpio.PinMode;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.impl.GpioPinImpl;

public class Fan extends GpioPinDevice {

	private GpioPinImpl[] pins = null;
	private String deviceId = null;
	
	@Override
	public void init(GpioPinImpl pin) {
		this.pins = new GpioPinImpl[1];
		this.pins[0] = pin;
		this.pins[0].setMode(PinMode.DIGITAL_OUTPUT);
		this.pins[0].setName(pin.getPin().getAddress()+"Digital_Output");
		this.pins[0].setProperty("Allocated_Naming_0", "0");
		this.pins[0].setTag("Pin_"+pin.getPin().getAddress());
		this.pins[0].setState(PinState.LOW);
		this.deviceId = pin.getPin().getAddress()+"Digital_Output";
	}

	@Override
	public void init(GpioPinImpl[] pins) {
		this.pins = new GpioPinImpl[pins.length];
		for(int i=0; i<pins.length; i++) {
			this.pins[i] = pins[i];
			this.pins[i].setMode(PinMode.DIGITAL_OUTPUT);
			this.pins[i].setName(pins[i].getPin().getAddress()+"Digital_Output");
			this.pins[i].setProperty("Allocated_Naming_"+i, String.valueOf(i));
			this.pins[i].setTag("Pin_"+pins[i].getPin().getAddress());
			this.pins[i].setState(PinState.LOW);
		}
		this.deviceId = pins[0].getPin().getAddress()+":"+pins.length;
	}

	@Override
	public void runDevice(Object value) {
		if(this.pins.length > 0) {
			for(int i=0; i<this.pins.length; i++) {
				this.pins[i].setState((PinState) value);
			}
		}
	}

	@Override
	public void stopDevice() {
		if(this.pins.length > 0) {
			for(int i=0; i<this.pins.length; i++) {
				this.pins[i].setState(PinState.LOW);
			}
		}
	}

	@Override
	public String getDeviceId() {
		return this.deviceId;
	}

	@Override
	public GpioPinImpl[] getPins() {
		return this.pins;
	}
	
}
