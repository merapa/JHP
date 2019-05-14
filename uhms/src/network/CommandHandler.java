package network;

import java.io.IOException;
import java.io.OutputStream;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

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
		String data = this.dataToString();
		he.sendResponseHeaders(200,data.getBytes().length);
		OutputStream os = he.getResponseBody();
		os.write(data.toString().getBytes());
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
	
		
		Element xmlRoot = this.doc.createElement("Root");
		Element xmlMType = this.doc.createElement("MessageType");
		Element xmlDevice = this.doc.createElement("Device");

		xmlRoot.appendChild(xmlMType);
		xmlRoot.appendChild(xmlDevice);
		
		xmlMType.setTextContent("Response");
		xmlDevice.setTextContent("Sensor");
		
		
		this.doc.appendChild(xmlRoot);
	}
	
	private String dataToString() {
		StringWriter sw = null;
		try {
			sw = new StringWriter();
			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer transformer = tf.newTransformer();
			transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
			transformer.setOutputProperty(OutputKeys.METHOD, "xml");
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
			transformer.transform(new DOMSource(this.doc), new StreamResult(sw));
		} catch(Exception e) {
			e.printStackTrace();
		}
		return sw.toString();
	}
}
