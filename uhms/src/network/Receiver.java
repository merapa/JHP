package network;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.Callable;

public class Receiver implements Callable<String>{
	
	private URL url = null;
	private String result = null;
	
	public Receiver() {
		try {
			this.url = new URL("http://iotmit.iptime.org:82");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
	
	private void sendPost(String parameters) throws Exception {
		StringBuilder contents = new StringBuilder();
		String pageContents = "";
		HttpURLConnection con = (HttpURLConnection)this.url.openConnection();
		InputStreamReader reader = new InputStreamReader(con.getInputStream(), "utf-8");
		
		BufferedReader buff = new BufferedReader(reader);
		
		while((pageContents = buff.readLine())!=null) {
			contents.append(pageContents);
			contents.append("\r\n");
		}
		
		this.result = contents.toString();
		buff.close();
		con.disconnect();
	}
	
	@Override
	public String call() throws Exception {
		this.sendPost(null);
		return result;
	}
	
	public String getResult() {
		return this.result;
	}
}