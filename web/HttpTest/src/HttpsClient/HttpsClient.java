package HttpsClient;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

import generator.SSLGenerator;

public class HttpsClient {
	
	private String host = "127.0.0.1";
    private int port = 9999;
    
	public HttpsClient() {

	}

	public HttpsClient(String host, int port){
        this.host = host;
        this.port = port;
    }
	
	public static void main(String[] args) {
		HttpsClient client = new HttpsClient();
        client.run();
	}

	// Start to run the client
    public void run(){
        SSLContext sslContext = new SSLGenerator("JKS","test.jks","passphrase","SunX509","TLSv1.2").createSSLContext();
         
        try{
            // Create socket factory
            SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();
             
            // Create socket
            SSLSocket sslSocket = (SSLSocket) sslSocketFactory.createSocket(this.host, this.port);
             
            System.out.println("SSL client started");
            new ClientThread(sslSocket).start();
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
