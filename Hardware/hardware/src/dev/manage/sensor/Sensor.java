package dev.manage.sensor;

import com.pi4j.io.gpio.Pin;

public class Sensor {

	public int[] parameterInputData;
	public int[] parameterResultData;
	public String cMessage = null;

	public Sensor() {
	}
	
	public void setSensor(Pin pin, int[] paramData) {
		
	}

	public int getData() {
		// TODO implement here
		return 0;
	}

	public void stop() {
		// TODO implement here
	}

}