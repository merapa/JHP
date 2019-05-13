package uhms;

import java.sql.Time;
import java.text.SimpleDateFormat;


public class EcologicalEnvironment {
	
	private DeviceManager dm = null;
	private String[] led_time = null;
	private int[] heater_value = null;
	private int[] cooler_value = null;
	private int[] level_value = null;
	private String[] feedtime = null;
	
	public EcologicalEnvironment(DeviceManager dm) {
		this.dm = dm;
		this.led_time = new String[2];
		this.heater_value = new int[2];
		this.cooler_value = new int[2];
		this.level_value = new int[2];
		this.feedtime = new String[2];
	}
	
	public boolean checkTo(int current_temp, int crruent_level) throws Exception {
		boolean temp = false;
		Time time = new Time(System.currentTimeMillis());
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:");
		if(sdf.format(time).equals(led_time[0])) {
			this.dm.getDeviceInfo().getGpioPinDevice("LED").setValues(0);
			this.dm.generateGpioPinDevice("LED");
			return true;
		}
		
		if(sdf.format(time).equals(led_time[1])) {
			this.dm.getDeviceInfo().getGpioPinDevice("LED").setValues(100);
			this.dm.generateGpioPinDevice("LED");
			return true;
		}
		
		for(int i=0; i<2; i++) {
			if(sdf.format(time).equals(feedtime[0])) {
				this.dm.getDeviceInfo().getGpioPinDevice("SERVOMOTOR").setValues(20);
				this.dm.generateGpioPinDevice("SERVOMOTOR");
				return true;
			}
		}
		
		if(heater_value[0] <= current_temp) {
			return true;
		}
		if(cooler_value[1] >= current_temp) {
			return true;
		}
		
		if(level_value[0] <= crruent_level) {
			return true;
		}
		return temp;
	}
	
	public DeviceManager getDm() {
		return dm;
	}

	public String[] getLed_time() {
		return led_time;
	}

	public void setLed_time(String[] led_time) {
		this.led_time = led_time;
	}

	public int[] getHeater_time() {
		return heater_value;
	}

	public void setHeater_time(int[] heater_value) {
		this.heater_value = heater_value;
	}

	public int[] getCooler_value() {
		return cooler_value;
	}

	public void setCooler_time(int[] cooler_value) {
		this.cooler_value = cooler_value;
	}

	public int[] getLevel_value() {
		return level_value;
	}

	public void setLevel_value(int[] level_value) {
		this.level_value = level_value;
	}

	public String[] getFeedtime() {
		return feedtime;
	}

	public void setFeedtime(String[] feedtime) {
		this.feedtime = feedtime;
	}
	
}