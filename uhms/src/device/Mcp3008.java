package device;

import java.io.IOException;

import com.pi4j.io.spi.SpiChannel;
import com.pi4j.io.spi.SpiMode;
import com.pi4j.io.spi.impl.SpiDeviceImpl;

public class Mcp3008 extends SpiPinDevice {
	private SpiDeviceImpl sdi = null;
	private int[] values = new int[8];

	@Override
	public void init(SpiChannel channel, SpiMode mode) {
		try {
			this.sdi = new SpiDeviceImpl(channel, mode);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public int getData(int channel) throws IOException{
		int value = 0;
		byte data[] = new byte[] {
				(byte) 0x01,
				(byte) (0x80 | ( (channel & 7) << 4 )),
				(byte) 0x00
		};
		byte[] result = null;
		try {
			result = this.sdi.write(data);
		} catch (IOException e) {
			e.printStackTrace();
		}

		StringBuffer sb = new StringBuffer(result.length * 2);
		String hexDec = null;
		for(int i=0; i<result.length; i++) {
			hexDec = "0" + Integer.toHexString(0xff & result[i]);
			sb.append(hexDec.substring(hexDec.length()-2));
		}
		value = Integer.parseInt(sb.toString(),16);
		return value;
	}

	@Override
	public void run() {
		for(int i=0; i<super.getDatachannel().length; i++) {
			if(super.getDatachannel()[i] > 0) {
				try {
					this.values[i] = this.getData(super.getDatachannel()[i]);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		this.values[0] = (int)(5.0*this.values[0]*100.0 /1024);//channel 7's lm35
	}

}
