package device;

import java.io.IOException;
import java.util.concurrent.Callable;

import com.pi4j.io.spi.SpiChannel;
import com.pi4j.io.spi.SpiMode;
import com.pi4j.io.spi.impl.SpiDeviceImpl;

public abstract class SpiPinDevice implements Callable<Integer[]>{

	private SpiDeviceImpl sdi = null;
	private String deviceId = null;
	private int[] Datachannel = null;
	
	public void init(SpiChannel channel, SpiMode mode) {
		try {
			this.setSdi(new SpiDeviceImpl(channel,mode));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public SpiDeviceImpl getSdi() {
		return sdi;
	}
	
	public void setSdi(SpiDeviceImpl sdi) {
		this.sdi = sdi;
	}
	
	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	
	public int[] getDatachannel() {
		return this.Datachannel;
	}
	
	public void setDatachannel(int index, int channel) {
		this.Datachannel[index] = channel;
	}
	
	public void initDatachannel(int channelLength,int... channels) {
		this.Datachannel = new int[channelLength];
		int i =0;
		for(int value : channels) {
			this.Datachannel[i] = value;
			i++;
		}
	}

	public abstract int getData(int channel) throws IOException;
}
