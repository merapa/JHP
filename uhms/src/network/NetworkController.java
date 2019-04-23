package network;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import uhms.Monitor;

public class NetworkController implements Runnable{
	
	private Monitor mo = null;
	private ScheduledExecutorService ses = null;
	private Receiver receiver = null;
	private Sender sender = null;
	private DBComunicator dc = null;
	
	public NetworkController(Monitor mo, ScheduledExecutorService ses) {
		this.mo = mo;
		this.ses = ses;
		this.receiver = new Receiver();
		this.sender = new Sender();
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

	public ScheduledExecutorService getScheduledExecutorService() {
		return ses;
	}

	public Monitor getMonitor() {
		return this.mo;
	}

	@Override
	public void run() {
		this.ses.schedule(this.receiver, 1, TimeUnit.HOURS);
		this.ses.schedule(this.sender, 1, TimeUnit.HOURS);
	}
}
