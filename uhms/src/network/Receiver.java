package network;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

import com.sun.net.httpserver.HttpServer;

public class Receiver {
	
	private HttpServer httpserver = null;
	private CommandHandler ch = null;
	public Receiver() {
		try {
			this.httpserver = HttpServer.create(new InetSocketAddress("192.168.0.100",8080), 10);
			this.ch = new CommandHandler();
			this.httpserver.createContext("/",this.ch);
			this.httpserver.setExecutor(Executors.newSingleThreadExecutor());
			this.httpserver.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}