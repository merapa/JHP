package network;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import uhms.Monitor;

public class Sender implements Runnable{

	private HttpURLConnection hc = null;
	private DataOutputStream dos = null;
	private BufferedReader br = null;
	private String messageType = null;
	private String[] data = null;
	
	public Sender(Monitor mo) {
		try {
			URL path = new URL("http://192.168.0.1:8080");
			this.hc = (HttpURLConnection) path.openConnection();
			this.hc.setRequestMethod("POST");
			this.hc.setConnectTimeout(3000);
			this.hc.setRequestProperty("Content-Type", "text/plain");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void setMessage(String messageType, String[] data) {
		this.messageType = messageType;
		this.data = data;
	}
	
	@Override
	public void run() {
		if(this.messageType != null && this.data != null) {
			try {
				this.dos = new DataOutputStream(this.hc.getOutputStream());
				this.dos.writeBytes("abc");
				this.dos.flush();
				this.dos.close();
				
				this.br = new BufferedReader(new InputStreamReader(this.hc.getInputStream()));
				String line;
		        StringBuffer response = new StringBuffer();
		        while ((line = this.br.readLine()) != null) {
		            response.append(line);
		            response.append('\r');
		        }
		        br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		this.messageType = null;
		this.data = null;
	}
	
}
