package dev;

import java.util.*;

import com.pi4j.io.gpio.Pin;
import dev.manage.Controller;
import dev.manage.actuator.ActuatorController;
import dev.manage.etcdevice.EtcDeviceController;
import dev.manage.sensor.SensorController;

public abstract class DeviceInfo {

	public DeviceInfo() {
	}
	private String deviceFuncName;
	private String deviceModuleName;
	private Pin gpioPin;

	private EtcDeviceController etcDevice = null;
	private SensorController sensor = null;
	private ActuatorController actuator = null;

	private Controller controller;


	public String getDeviceFuncName() {
		// TODO implement here
		return "";
	}

	public void setDeviceFuncName(String name) {
		// TODO implement here
	}

	public String getDeviceModuleName() {
		// TODO implement here
		return "";
	}

	public void setDeviceModuleName(String name) {
		// TODO implement here
	}

	public Pin getGpioPin() {
		// TODO implement here
		return null;
	}

	public void setGpioPin(Pin pin) {
		// TODO implement here
	}

	public Controller getControllInfo() {
		// TODO implement here
		return null;
	}

	public void setControllInfo(String command) {
		// TODO implement here
	}

}