package network;

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

public class CommandInterpreter {
	
	private DocumentBuilderFactory dbf = null;
	private DocumentBuilder db = null;
	private Document doc = null;
	
	public CommandInterpreter() {
		try {
			this.dbf = DocumentBuilderFactory.newInstance();
			this.db = this.dbf.newDocumentBuilder();
			this.doc = this.db.newDocument();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String makeXmlData(String requestType, String[] data) {
		responseData(requestType,data);
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
	
	
	private Document responseData(String requestType, String[] data) {
		this.doc = null;
		Element[] result = new Element[data.length];
		Element root = this.doc.createElement("Root");
		switch(requestType) {
		case "GETDATA" :
			for(int i=0; i<data.length; i++) {
				result[i] = this.doc.createElement("Sensor_"+i);
				result[i].setTextContent(data[i]);
				root.appendChild(result[i]);
			}
			break;
		case "GENERATE" :
			result[0] = this.doc.createElement("Result");
			result[0].setTextContent(data[0]);
			root.appendChild(result[0]);
			break;
		case "SHUTDOWN" :
			result[0] = this.doc.createElement("Shutdown");
			result[0].setTextContent(data[0]);
			root.appendChild(result[0]);
			break;
		case "ERROR" :
			result[0] = this.doc.createElement("Error");
			result[0].setTextContent(data[0]);
			root.appendChild(result[0]);
			break;
		default :
			Element unkownerror = this.doc.createElement("error");
			unkownerror.setTextContent("Unknown Error");
			root.appendChild(unkownerror);
			break;
		}
		this.doc.appendChild(root);
		return this.doc;
	}
}
