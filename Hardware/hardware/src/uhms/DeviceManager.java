package uhms;

import java.io.IOException;

import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.RaspiPin;
import com.pi4j.io.spi.SpiChannel;
import com.pi4j.io.spi.SpiDevice;
import com.pi4j.io.spi.SpiFactory;
import com.pi4j.util.CommandArgumentParser;

public class DeviceManager {
	
	private Pin[] pin = null;
	private SpiDevice[] spi = null;
	
	public static void main(String[] args) {
		DeviceManager dm = new DeviceManager();
		int[] pinNum = {1,2,3,4,5,6,7,8};
		dm.pinSetting(pinNum,args);
		dm.spi = new SpiDevice[2];
		try {
			dm.spi[0] = SpiFactory.getInstance(SpiChannel.CS0,
			        SpiDevice.DEFAULT_SPI_SPEED, 
			        SpiDevice.DEFAULT_SPI_MODE);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void pinSetting(int[] pinNum,String[] args) {
		Pin tpin = null;
		for(int i=0; i<pinNum.length; i++) {
			switch(pinNum[i]) {
			case 0: tpin = RaspiPin.GPIO_00; break;
			case 1: tpin = RaspiPin.GPIO_01; break;
			case 2: tpin = RaspiPin.GPIO_02; break;
			case 3: tpin = RaspiPin.GPIO_03; break;
			case 4: tpin = RaspiPin.GPIO_04; break;
			case 5: tpin = RaspiPin.GPIO_05; break;
			case 6: tpin = RaspiPin.GPIO_06; break;
			case 7: tpin = RaspiPin.GPIO_07; break;
			case 8: tpin = RaspiPin.GPIO_08; break;
			case 9: tpin = RaspiPin.GPIO_09; break;
			case 10: tpin = RaspiPin.GPIO_10; break;
			case 11: tpin = RaspiPin.GPIO_11; break;
			case 12: tpin = RaspiPin.GPIO_12; break;
			case 13: tpin = RaspiPin.GPIO_13; break;
			case 14: tpin = RaspiPin.GPIO_14; break;
			case 15: tpin = RaspiPin.GPIO_15; break;
			case 16: tpin = RaspiPin.GPIO_16; break;
			case 17: tpin = RaspiPin.GPIO_17; break;
			case 18: tpin = RaspiPin.GPIO_18; break;
			case 19: tpin = RaspiPin.GPIO_19; break;
			case 20: tpin = RaspiPin.GPIO_20; break;
			case 21: tpin = RaspiPin.GPIO_21; break;
			case 22: tpin = RaspiPin.GPIO_22; break;
			case 23: tpin = RaspiPin.GPIO_23; break;
			case 24: tpin = RaspiPin.GPIO_24; break;
			case 25: tpin = RaspiPin.GPIO_25; break;
			case 26: tpin = RaspiPin.GPIO_26; break;
			case 27: tpin = RaspiPin.GPIO_27; break;
			case 28: tpin = RaspiPin.GPIO_28; break;
			case 29: tpin = RaspiPin.GPIO_29; break;
			case 30: tpin = RaspiPin.GPIO_30; break;
			case 31: tpin = RaspiPin.GPIO_31; break;
			default:
				System.out.println("초기화 실패");
			}
			this.pin[i] = CommandArgumentParser.getPin(
	                RaspiPin.class, tpin, args);
		}
	}

	public void ledOperating() {
		
	}
	
	public void CoolerOperating() {
		
	}
	
	public void heaterOperating() {
		
	}
	
	public void servoMotorOperating() {
		
	}
	
	public void stepMotorOperating() {
		
	}
	
	public void levelSensorRead() {
		
	}
	
	public void TemperatureSensor() {
		
	}
}
