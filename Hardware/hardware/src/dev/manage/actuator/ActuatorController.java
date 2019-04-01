package dev.manage.actuator;

import com.pi4j.io.gpio.Pin;
import dev.manage.Controller;

public class ActuatorController implements Controller {
	
	public Actuator actuator;

	public ActuatorController() {
	}

	@Override
	public void init(Pin pin) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getData() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		
	}
	
}