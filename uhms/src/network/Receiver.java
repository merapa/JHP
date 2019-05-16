package network;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.sun.net.httpserver.HttpServer;

import uhms.Monitor;

public class Receiver implements Runnable{
	
	private HttpServer httpserver = null;
	private CommandHandler ch = null;
	public Receiver(Monitor mo) {
		try {
			this.httpserver = HttpServer.create(new InetSocketAddress("192.168.0.100",8080), 10);
			this.ch = new CommandHandler();
			this.httpserver.createContext("/",this.ch);
			this.httpserver.setExecutor(mo.getScheduledExecutorService());
			this.httpserver.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void setMessage(String message, String[] data) {
		this.ch.setMessage(message, data);
	}

	
	@Override
	public void run() {
		
	}
}