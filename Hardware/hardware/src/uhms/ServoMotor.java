package uhms;

import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinPwmOutput;
import com.pi4j.io.gpio.Pin;

public class ServoMotor {

	private GpioPinPwmOutput pwmPin = null;

	public ServoMotor(Pin pin) {
		pwmPin = GpioFactory.getInstance().provisionPwmOutputPin(pin);
	}
	
	public void setMotorConfig(int range, int clock) {
		com.pi4j.wiringpi.Gpio.pwmSetMode(com.pi4j.wiringpi.Gpio.PWM_MODE_MS);
        com.pi4j.wiringpi.Gpio.pwmSetRange(range);
        com.pi4j.wiringpi.Gpio.pwmSetClock(clock);
	}
	
	public void rotate(int value) {
		pwmPin.setPwm(value);
	}
}
