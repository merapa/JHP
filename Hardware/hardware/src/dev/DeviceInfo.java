package dev;

import com.pi4j.io.gpio.Pin;
import dev.manage.Controller;
import dev.manage.actuator.Actuator;
import dev.manage.etcdevice.EtcDevice;
import dev.manage.sensor.Sensor;

public class DeviceInfo {

	public DeviceInfo() {
	}

	private String deviceFuncName;
	private String deviceModuleName;
	private Pin gpioPin;
	private Controller controllInfo;
	public EtcDevice etcDevice;
	public Sensor sensor;
	public Actuator actuator;


	public String getDeviceFuncName() {
		return this.deviceFuncName;
	}

	public void setDeviceFuncName(String name) {
		
	}

	public String getDeviceModuleName() {
		return this.deviceModuleName;
	}

	public void setDeviceModuleName(String name) {
		
	}

	public Pin getGpioPin() {
		return this.gpioPin;
	}

	public void setGpioPin(Pin pin) {
		
	}

	public Controller getControllInfo() {
		return this.controllInfo;
	}

	public void setControllInfo(String command) {
		
	}

}