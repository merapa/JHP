package network;

import java.io.IOException;
import java.io.OutputStream;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;


public class CommandHandler implements HttpHandler {
	
	private CommandInterpreter ci = null;
	private String message = null;
	private String[] data = null;
	
	public CommandHandler() {
		this.ci = new CommandInterpreter();
	}
	
	public void setMessage(String message, String[] data) {
		this.message = message;
		this.data = data;
	}
	
	@Override
	public void handle(HttpExchange he) throws IOException {
		String method = he.getRequestMethod();
		String data = null;
		switch(method) {
		case "GET" :
			data = this.ci.makeXmlData(this.message, this.data);
			he.sendResponseHeaders(200,data.getBytes().length);
			break;
		case "POST" :
			
			break;
		}
		
		OutputStream os = he.getResponseBody();
		os.write(data.toString().getBytes());
		os.close();
	}
}
