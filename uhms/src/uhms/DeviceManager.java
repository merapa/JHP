package uhms;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioProvider;
import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.PinMode;
import com.pi4j.io.gpio.RaspiPin;
import com.pi4j.io.gpio.impl.GpioPinImpl;
import com.pi4j.io.spi.SpiChannel;
import com.pi4j.io.spi.SpiMode;
import com.pi4j.wiringpi.Gpio;

import device.Fan;
import device.GpioPinDevice;
import device.LED;
import device.Mcp3008;
import device.ServoMotor;
import device.SpiPinDevice;
import device.StepperMotor;

public class DeviceManager {

	private ArrayList<GpioPinDevice> gpd = null;
	private ArrayList<SpiPinDevice> spd = null;
	private GpioProvider gp = null;
	private GpioController gc = null;
	
	public DeviceManager(int gNum, int sNum) {
		this.gpd = new ArrayList<GpioPinDevice>(gNum);
		this.spd = new ArrayList<SpiPinDevice>(sNum);
		this.gp = GpioFactory.getDefaultProvider();
		this.gc = GpioFactory.getInstance();
	}
	
	public void initDevice() {
		File f = new File("./config/deviceConfig");
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(f));
			String[] line = null;
			Gpio.pwmSetClock(20);
			while((line = br.readLine().split("\\s")) != null ){
				if(line[0].equals("LED")) {
					GpioPinDevice led = new LED();
					GpioPinImpl gpin = new GpioPinImpl(this.gc,this.gp,this.returnPin(Integer.valueOf(line[1])));
					this.pinSetting(gpin, "LED", line[1]);
					led.init(gpin);
					this.gpd.add(led);
				} else if(line[0].equals("COOLER")) {
					GpioPinDevice cooler = new Fan();
					GpioPinImpl gpin = new GpioPinImpl(this.gc,this.gp,this.returnPin(Integer.valueOf(line[1])));
					this.pinSetting(gpin, "COOLER", line[1]);
					cooler.init(gpin);
					this.gpd.add(cooler);
				} else if(line[0].equals("HEATER")) {
					GpioPinDevice heater = new Fan();
					GpioPinImpl gpin = new GpioPinImpl(this.gc,this.gp,this.returnPin(Integer.valueOf(line[1])));
					this.pinSetting(gpin, "HEATER", line[1]);
					heater.init(gpin);
					this.gpd.add(heater);
				} else if(line[0].equals("SERVOMOTOR")) {
					GpioPinDevice sm = new ServoMotor();
					GpioPinImpl gpin = new GpioPinImpl(this.gc,this.gp,this.returnPin(Integer.valueOf(line[1])));
					this.pinSetting(gpin, "SERVOMOTOR", line[1]);
					sm.init(gpin);
					this.gpd.add(sm);
				} else if(line[0].equals("STEPPERMOTR")) {
					GpioPinDevice sm = new StepperMotor();
					GpioPinImpl[] gpins = new GpioPinImpl[4];
					for(int i=0; i<4; i++) {
						 gpins[i] = new GpioPinImpl(this.gc,this.gp,this.returnPin(Integer.valueOf(line[i])));
						 this.pinSetting(gpins[i], "STEPPERMOTOR", line[i]);
					}
					sm.init(gpins);
					this.gpd.add(sm);
				} else if(line[0].equals("MCP3008")) {
					SpiPinDevice spd = new Mcp3008();
					spd.init(SpiChannel.CS0, SpiMode.MODE_0);
					this.spd.add(spd);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		DeviceManager dm = new DeviceManager(5,1);
		Scanner sc = new Scanner(System.in);
		dm.initDevice();
		String[] command = null;
		while(!command[0].equals("exit")) {
			command = sc.nextLine().split("\\s");
			if(command[0].equals("LED")){
				dm.gpd.get(0).runDevice(Integer.parseInt(command[1]));
			} else if(command[0].equals("COOLER")) {
				dm.gpd.get(1).runDevice(Integer.parseInt(command[1]));
			} else if(command[0].equals("HEATER")) {
				dm.gpd.get(2).runDevice(Integer.parseInt(command[1]));
			} else if(command[0].equals("SERVOMOTOR")) {
				dm.gpd.get(3).runDevice(Integer.parseInt(command[1]));
			} else if(command[0].equals("STEPPERMOTOR")) {
				dm.gpd.get(4).runDevice(Integer.parseInt(command[1]));
			} else if(command[0].equals("MCP3008")) {
				System.out.println(dm.spd.get(0).getData(0));
			} else {
				System.out.println("명령어 없음");
			}
		}
		dm.shutdown();
	}
	
	private Pin returnPin(int pnum) {
		Pin pin = null;
		switch(pnum) {
		case 0: pin = RaspiPin.GPIO_00;break;
		case 1: pin = RaspiPin.GPIO_01;break;
		case 2: pin = RaspiPin.GPIO_02;break;
		case 3: pin = RaspiPin.GPIO_03;break;
		case 4: pin = RaspiPin.GPIO_04;break;
		case 5: pin = RaspiPin.GPIO_05;break;
		case 6: pin = RaspiPin.GPIO_06;break;
		case 7: pin = RaspiPin.GPIO_07;break;
		case 8: pin = RaspiPin.GPIO_08;break;
		case 9: pin = RaspiPin.GPIO_09;break;
		case 10: pin = RaspiPin.GPIO_10;break;
		case 11: pin = RaspiPin.GPIO_11;break;
		case 12: pin = RaspiPin.GPIO_12;break;
		case 13: pin = RaspiPin.GPIO_13;break;
		case 14: pin = RaspiPin.GPIO_14;break;
		case 15: pin = RaspiPin.GPIO_15;break;
		case 16: pin = RaspiPin.GPIO_16;break;
		case 17: pin = RaspiPin.GPIO_17;break;
		case 18: pin = RaspiPin.GPIO_18;break;
		case 19: pin = RaspiPin.GPIO_19;break;
		case 20: pin = RaspiPin.GPIO_20;break;
		case 21: pin = RaspiPin.GPIO_21;break;
		case 22: pin = RaspiPin.GPIO_22;break;
		case 23: pin = RaspiPin.GPIO_23;break;
		case 24: pin = RaspiPin.GPIO_24;break;
		case 25: pin = RaspiPin.GPIO_25;break;
		case 26: pin = RaspiPin.GPIO_26;break;
		case 27: pin = RaspiPin.GPIO_27;break;
		case 28: pin = RaspiPin.GPIO_28;break;
		case 29: pin = RaspiPin.GPIO_29;break;
		case 30: pin = RaspiPin.GPIO_30;break;
		case 31: pin = RaspiPin.GPIO_31;break;
		default :
			break;
		}
		return pin;
	}
	
	private void pinSetting(GpioPinImpl pin, String Name, String number) {
		switch(Name) {
		case "LED" :
			pin.setMode(PinMode.DIGITAL_OUTPUT);
			pin.setName("LED");
			pin.setProperty(Name+number, number);
			break;
		case "FAN" : 
			pin.setMode(PinMode.DIGITAL_OUTPUT);
			pin.setName("FAN");
			pin.setProperty(Name+number, number);
			break;
		case "SERVOMOTOR" : 
			pin.setMode(PinMode.SOFT_PWM_OUTPUT);
			pin.setPwmRange(128);
			pin.setName("ServoMotor");
			pin.setProperty(Name+number, number);
			break;
		case "STEPPERMOTOR" : 
			pin.setMode(PinMode.DIGITAL_OUTPUT);
			pin.setName("StepperMotor");
			pin.setProperty(Name+number, number);
			break;
		default: break;
		}
		
	}
	
	private void shutdown() {
		this.gc.shutdown();
		this.gp.shutdown();
	}
}
