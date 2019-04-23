package uhms;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioProvider;
import com.pi4j.io.gpio.Pin;
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

public class DeviceInfo {
	
	private HashMap<String, GpioPinDevice> gpd = null;
	private HashMap<String, SpiPinDevice> spd = null;
	private GpioProvider gp = null;
	private GpioController gc = null;
	private File f = null;
	
	public DeviceInfo(String filePath) {
		this.gpd = new HashMap<String ,GpioPinDevice>();
		this.spd = new HashMap<String, SpiPinDevice>();
		this.gp = GpioFactory.getDefaultProvider();
		this.gc = GpioFactory.getInstance();
		this.f = new File(filePath);
		this.readSetting();
	}
	
	public HashMap<String ,GpioPinDevice> getGpd() {
		return this.gpd;
	}
	
	public HashMap<String, SpiPinDevice> getSpd() {
		return this.spd;
	}
	
	public GpioPinDevice getGpioPinDevice(String name) {
		return this.gpd.get(name);
	}
	
	public SpiPinDevice getSpiPinDevice(String name) {
		return this.spd.get(name);
	}
	
	private void readSetting() {
		BufferedReader br = null;
		Gpio.wiringPiSetup();
		Gpio.pwmSetClock(20);
		Gpio.pwmSetMode(Gpio.PWM_MODE_MS);
		try {
			br = new BufferedReader(new FileReader(this.f));
			String rl = null;
			GpioPinDevice gdevice = null;
			SpiPinDevice sdevice = null;
			GpioPinImpl[] gpins = null;
			while((rl = br.readLine())!=null) {
				String[] line = rl.split("\\s");
				switch(line[0]) {
				case "LED":
					gdevice = new LED();
					break;
				case "COOLER":
					gdevice = new Fan();
					break;
				case "HEATER":
					gdevice = new Fan();
					break;
				case "SERVOMOTOR":
					gdevice = new ServoMotor();
					break;
				case "STEPPERMOTOR":
					gdevice = new StepperMotor();
					break;
				case "MCP3008":
					sdevice = new Mcp3008();
					break;
				default:
					break;
				}
				
				if(gdevice != null) {
					gpins = new GpioPinImpl[line.length-1];
					for(int i=0; i<line.length-1; i++) {
						gpins[i] = new GpioPinImpl(this.gc,this.gp,this.returnPin(line[i+1]));
					}
					this.gpd.put(line[0], gdevice);
					this.gpd.get(line[0]).init(gpins);
					this.gpd.get(line[0]).setDeviceId(line[0]);
				} else if (sdevice != null) {
					this.spd.put(line[0],sdevice);
					this.spd.get(line[0]).init(SpiChannel.CS0, SpiMode.MODE_0);
					this.spd.get(line[0]).setDeviceId(line[0]);
				}
				sdevice = null;
				gdevice = null;
				gpins = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void shutdown() {
		this.gc.shutdown();
		this.gp.shutdown();
	}
	
	private Pin returnPin(String pnum) {
		Pin pin = null;
		switch(pnum) {
		case "0": pin = RaspiPin.GPIO_00;break;
		case "1": pin = RaspiPin.GPIO_01;break;
		case "2": pin = RaspiPin.GPIO_02;break;
		case "3": pin = RaspiPin.GPIO_03;break;
		case "4": pin = RaspiPin.GPIO_04;break;
		case "5": pin = RaspiPin.GPIO_05;break;
		case "6": pin = RaspiPin.GPIO_06;break;
		case "7": pin = RaspiPin.GPIO_07;break;
		case "8": pin = RaspiPin.GPIO_08;break;
		case "9": pin = RaspiPin.GPIO_09;break;
		case "10": pin = RaspiPin.GPIO_10;break;
		case "11": pin = RaspiPin.GPIO_11;break;
		case "12": pin = RaspiPin.GPIO_12;break;
		case "13": pin = RaspiPin.GPIO_13;break;
		case "14": pin = RaspiPin.GPIO_14;break;
		case "15": pin = RaspiPin.GPIO_15;break;
		case "16": pin = RaspiPin.GPIO_16;break;
		case "17": pin = RaspiPin.GPIO_17;break;
		case "18": pin = RaspiPin.GPIO_18;break;
		case "19": pin = RaspiPin.GPIO_19;break;
		case "20": pin = RaspiPin.GPIO_20;break;
		case "21": pin = RaspiPin.GPIO_21;break;
		case "22": pin = RaspiPin.GPIO_22;break;
		case "23": pin = RaspiPin.GPIO_23;break;
		case "24": pin = RaspiPin.GPIO_24;break;
		case "25": pin = RaspiPin.GPIO_25;break;
		case "26": pin = RaspiPin.GPIO_26;break;
		case "27": pin = RaspiPin.GPIO_27;break;
		case "28": pin = RaspiPin.GPIO_28;break;
		case "29": pin = RaspiPin.GPIO_29;break;
		case "30": pin = RaspiPin.GPIO_30;break;
		case "31": pin = RaspiPin.GPIO_31;break;
		case "GPIO_00": pin = RaspiPin.GPIO_00;break;
		case "GPIO_01": pin = RaspiPin.GPIO_01;break;
		case "GPIO_02": pin = RaspiPin.GPIO_02;break;
		case "GPIO_03": pin = RaspiPin.GPIO_03;break;
		case "GPIO_04": pin = RaspiPin.GPIO_04;break;
		case "GPIO_05": pin = RaspiPin.GPIO_05;break;
		case "GPIO_06": pin = RaspiPin.GPIO_06;break;
		case "GPIO_07": pin = RaspiPin.GPIO_07;break;
		case "GPIO_08": pin = RaspiPin.GPIO_08;break;
		case "GPIO_09": pin = RaspiPin.GPIO_09;break;
		case "GPIO_10": pin = RaspiPin.GPIO_10;break;
		case "GPIO_11": pin = RaspiPin.GPIO_11;break;
		case "GPIO_12": pin = RaspiPin.GPIO_12;break;
		case "GPIO_13": pin = RaspiPin.GPIO_13;break;
		case "GPIO_14": pin = RaspiPin.GPIO_14;break;
		case "GPIO_15": pin = RaspiPin.GPIO_15;break;
		case "GPIO_16": pin = RaspiPin.GPIO_16;break;
		case "GPIO_17": pin = RaspiPin.GPIO_17;break;
		case "GPIO_18": pin = RaspiPin.GPIO_18;break;
		case "GPIO_19": pin = RaspiPin.GPIO_19;break;
		case "GPIO_20": pin = RaspiPin.GPIO_20;break;
		case "GPIO_21": pin = RaspiPin.GPIO_21;break;
		case "GPIO_22": pin = RaspiPin.GPIO_22;break;
		case "GPIO_23": pin = RaspiPin.GPIO_23;break;
		case "GPIO_24": pin = RaspiPin.GPIO_24;break;
		case "GPIO_25": pin = RaspiPin.GPIO_25;break;
		case "GPIO_26": pin = RaspiPin.GPIO_26;break;
		case "GPIO_27": pin = RaspiPin.GPIO_27;break;
		case "GPIO_28": pin = RaspiPin.GPIO_28;break;
		case "GPIO_29": pin = RaspiPin.GPIO_29;break;
		case "GPIO_30": pin = RaspiPin.GPIO_30;break;
		case "GPIO_31": pin = RaspiPin.GPIO_31;break;
		default :
			break;
		}
		return pin;
	}
}
