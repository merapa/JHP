package network;

import uhms.Monitor;

public class NetworkController {
	
	private Monitor mo = null;
	private Receiver receiver = null;
	private Sender sender = null;
	private DBComunicator dc = null;
	
	public NetworkController(Monitor mo) {
		this.mo = mo;
		this.receiver = new Receiver();
		this.sender = new Sender("");
		this.dc = new DBComunicator();
	}

	public Receiver getReceiver() {
		return receiver;
	}

	public void setReceiver(Receiver receiver) {
		this.receiver = receiver;
	}

	public Sender getSender() {
		return sender;
	}

	public void setSender(Sender sender) {
		this.sender = sender;
	}

	public DBComunicator getDc() {
		return dc;
	}

	public void setDc(DBComunicator dc) {
		this.dc = dc;
	}

	public Monitor getMonitor() {
		return this.mo;
	}

}
