package device;

import java.io.IOException;

public class Mcp3008 extends SpiPinDevice {
	
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
			result = this.getSdi().write(data);
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
		for(int i=0; i<super.getchannel().length; i++) {
			try {
				super.getchannel()[i] = getData(i);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		super.getchannel()[7] = (int)(5.0*super.getchannel()[7]*100.0 /1024);//channel 7's lm35
	}
}
