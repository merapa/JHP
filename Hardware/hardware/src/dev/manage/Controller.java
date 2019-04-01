package dev.manage;

import com.pi4j.io.gpio.Pin;

public interface Controller {

	public void init(Pin pin);
	public void execute();
	public int getData();
	public void stop();

}