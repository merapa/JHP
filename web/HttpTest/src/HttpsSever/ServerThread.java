package HttpsSever;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;

public class ServerThread extends Thread {

	private SSLSocket sslSocket = null;
	
	public ServerThread(SSLSocket sslSocket) {
		this.sslSocket = sslSocket;
	}

	@Override
	public void run() {
		this.sslSocket.setEnabledCipherSuites(this.sslSocket.getSupportedCipherSuites());

        try{
            // Start handshake
        	this.sslSocket.startHandshake();
 
            // Get session after the connection is established
            SSLSession sslSession = this.sslSocket.getSession();
            System.out.println("SSLSession :");
            System.out.println("\tProtocol : "+sslSession.getProtocol());
            System.out.println("\tCipher suite : "+sslSession.getCipherSuite());
             
            // Start handling application content
            InputStream inputStream = this.sslSocket.getInputStream();
            OutputStream outputStream = this.sslSocket.getOutputStream(); 
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(outputStream));
             
            String line = null;
            while((line = bufferedReader.readLine()) != null){
                System.out.println("Inut : "+line);
                if(line.trim().isEmpty()){
                    break;
                }
            }
             
            // Write data
            printWriter.print("HTTP/1.1 200\r\n");
            printWriter.flush();
            this.sslSocket.close();
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
	}
	
}
