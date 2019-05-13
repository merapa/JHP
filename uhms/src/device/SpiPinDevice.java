package device;

import java.io.IOException;

import com.pi4j.io.spi.SpiChannel;
import com.pi4j.io.spi.SpiMode;
import com.pi4j.io.spi.impl.SpiDeviceImpl;

public abstract class SpiPinDevice implements Runnable{

	private SpiDeviceImpl sdi = null;
	private int[] Datachannel = null;
	private String deviceId = null;

	public void init(SpiChannel channel, SpiMode mode, int channelLength, String deviceId){
		try {
			this.sdi = new SpiDeviceImpl(channel,mode);
			this.Datachannel = new int[channelLength];
			this.deviceId = deviceId;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public SpiDeviceImpl getSdi() {
		return sdi;
	}

	public int[] getchannel() {
		return this.Datachannel;
	}
	
	public String getDeviceId() {
		return deviceId;
	}

	public abstract int getData(int channel) throws IOException;
}
