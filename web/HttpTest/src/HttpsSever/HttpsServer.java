package HttpsSever;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;

import generator.SSLGenerator;

public class HttpsServer {
	private int port = 9999;
    private boolean isServerDone = false;
     
    public HttpsServer(){      
    }
    
    public HttpsServer(int port){
        this.port = port;
    }
    
    // Start to run the server
    public void run(){
        SSLContext sslContext = new SSLGenerator("JKS","test.jks","passphrase","SunX509","TLSv1.2").createSSLContext();
         
        try{
            // Create server socket factory
            SSLServerSocketFactory sslServerSocketFactory = sslContext.getServerSocketFactory();
             
            // Create server socket
            SSLServerSocket sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(this.port);
             
            System.out.println("SSL server started");
            while(!isServerDone){
                SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept();
                 
                // Start the server thread
                new ServerThread(sslSocket).start();
            }
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
    
	public static void main(String[] args) {
		HttpsServer server = new HttpsServer();
        server.run();
	}

}
