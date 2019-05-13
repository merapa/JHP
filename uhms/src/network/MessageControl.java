package network;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;


public class MessageControl {
	private DocumentBuilderFactory docFactory = null;
	private DocumentBuilder docBuilder = null;
	
	public MessageControl() {
		try {
			this.docFactory = DocumentBuilderFactory.newInstance();
			this.docBuilder = this.docFactory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
	}
	
	public String writeXMLData(String[] parameter) {
		
		Document doc = this.docBuilder.newDocument();
		doc.setXmlStandalone(true);
		
		Element[] el = {
				doc.createElement("Root"),
				doc.createElement("Time"),
				doc.createElement("Contorl")
		};
		
		el[0].setAttribute("MessageKinds", parameter[0]);
		el[0].setAttribute("Version", parameter[1]);
		el[0].setAttribute("Type", parameter[2]);
		el[1].setAttribute("GTM", parameter[3]);
		el[1].setAttribute("Nation", parameter[4]);
		el[1].setTextContent(parameter[5]);
		el[2].setAttribute("device", parameter[6]);
		el[2].setTextContent(parameter[7]);
		
		el[0].appendChild(el[1]);
		el[0].appendChild(el[2]);
		
		return doc.toString();
	}
	
	public String readXMLData(InputSource is) {
		Document doc = null;
		XPathFactory xpathFactory = null;
		XPath xpath = null;
		XPathExpression expr = null;
		NodeList nodeList = null;
		try {
			doc = this.docBuilder.parse(is);
			xpathFactory = XPathFactory.newInstance();
			xpath = xpathFactory.newXPath();
			expr = xpath.compile("//Root");
			nodeList = (NodeList)expr.evaluate(doc, XPathConstants.NODESET);
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (XPathExpressionException e) {
			e.printStackTrace();
		}
		return nodeList.toString();
	}
}
