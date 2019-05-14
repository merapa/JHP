package network;

public class CommandInterpreter {
	
	private String[] commands = null;
	
	private String responseData(String requestType) {
		String temp = null;
		switch(requestType) {
		case "GETDATA" : break;
		case "GENERATE" : break;
		case "SHUTDOWN" : break;
		default : break;
		}
		return temp;
	}
	
	private String sendData(String responseType) {
		String temp = null;
		switch(responseType) {
		case "STATE" : break;
		case "RESULT" : break;
		}
		return temp;
	}
}
