package device;

import com.pi4j.io.gpio.PinMode;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.impl.GpioPinImpl;

public class StepperMotor extends GpioPinDevice {

	private GpioPinImpl[] pins = null;
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
		this.pins[0].setMode(PinMode.DIGITAL_OUTPUT);
		this.pins[0].setName(pin.getPin().getAddress()+"Digital_Output");
		this.pins[0].setProperty("Allocated_Naming_0", "0");
		this.pins[0].setTag("Pin_"+pin.getPin().getAddress());
		this.pins[0].setState(PinState.LOW);
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
	}

	@Override
	public void runDevice(int value) {
		if((int)value > 0) {
			this.rotateR(value);
		} else if((int) value < 0) {
			this.rotateL((value*(-1)));
		}
		this.stopDevice();
	}

	@Override
	public void stopDevice() {
		try {
			this.phaseState(new int[]{0,0,0,0}, 10);
		} catch (InterruptedException e) {
			e.printStackTrace();
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

	private void rotateR(int step) {
		try {
			for(int i=0; i<step; i++) {
				for(int j=0; j<this.rotateRData.length; j++) {
					this.phaseState(this.rotateRData[j], 10);
					}
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	}
	
	private void rotateL(int step) {
		try {
			for(int i=0; i<step; i++) {
				for(int j=0; j<this.rotateLData.length; j++) {
					this.phaseState(this.rotateLData[j], 10);
					}
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
				}
	}

	private void phaseState(int[] data, int delay) throws InterruptedException {
		for(int i=0; i<data.length; i++) {
			if(data[i] > 0) {
				this.pins[i].high();
			} else {
				this.pins[i].low();
			}
		}
		Thread.sleep(delay);
	}
}
