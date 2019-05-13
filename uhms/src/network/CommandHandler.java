package network;

import java.io.IOException;
import java.io.OutputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class CommandHandler implements HttpHandler {

	private Document doc = null;
	
	@Override
	public void handle(HttpExchange he) throws IOException {
		String method = he.getRequestMethod();
		/*String body = "<html>" +
				"<header></header>"+
				"<body>Hello</body>"+
				"</html>";*/
		this.createDocument();
		he.sendResponseHeaders(200,this.doc.toString().getBytes().length);
		OutputStream os = he.getResponseBody();
		os.write(this.doc.toString().getBytes());
		os.close();
		/*
		switch(method) {
		case "GET" : hello(he); break;
		case "POST" : break;
		default : break;
		}
		*/
	}
	
	private void createDocument() {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = null;
		try {
			builder = factory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		
		this.doc = builder.newDocument();
		
		Element html = this.doc.createElement("html");
		Element head = this.doc.createElement("head");
		html.appendChild(head);
		System.out.println(html);
		System.out.println(head);
		System.out.println(this.doc);
	}
}
