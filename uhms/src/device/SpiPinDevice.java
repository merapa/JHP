package device;

import java.io.IOException;

import com.pi4j.io.spi.SpiChannel;
import com.pi4j.io.spi.SpiMode;
import com.pi4j.io.spi.impl.SpiDeviceImpl;

public abstract class SpiPinDevice {

	private SpiDeviceImpl sdi = null;
	
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
	
	public abstract int getData(int channel);
}
