package generator;

import java.io.FileInputStream;
import java.security.KeyStore;

import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;

public class SSLGenerator {
	/* 테스트값
	 * KeyFormatName   = "JKS",
	 * KeyFileName     = "test.jks"
	 * KeyPasswordName = "passphrase"
	 * KeyManagerNmae  = "SunX509"
	 * ProtocolName    = "TLSV1.2"
	 * */
	private String keyFormatName;
	private String keyFileName;
	private String keyPasswordName;
	private String keyManagerName;
	private String protocolName;
	
	public SSLGenerator(String keyFormatName, String keyFileName, String keyPasswordName, String keyManagerName, String protocolName) {
		this.keyFormatName = keyFormatName;
		this.keyFileName = keyFileName;
		this.keyPasswordName = keyPasswordName;
		this.keyManagerName = keyManagerName;
		this.protocolName = protocolName;
	}
	
	public String getKeyFormatName() {
		return keyFormatName;
	}

	public void setKeyFormatName(String keyFormatName) {
		this.keyFormatName = keyFormatName;
	}

	public String getKeyFileName() {
		return keyFileName;
	}
	
	public void setKeyFileName(String keyFileName) {
		this.keyFileName = keyFileName;
	}

	public String getKeyPasswordName() {
		return keyPasswordName;
	}

	public void setKeyPasswordName(String keyPasswordName) {
		this.keyPasswordName = keyPasswordName;
	}

	public String getKeyManagerName() {
		return keyManagerName;
	}

	public void setKeyManagerName(String keyManagerName) {
		this.keyManagerName = keyManagerName;
	}

	public String getProtocolName() {
		return protocolName;
	}

	public void setProtocolName(String protocolName) {
		this.protocolName = protocolName;
	}

	public SSLContext createSSLContext(){
        try{
            KeyStore keyStore = KeyStore.getInstance(this.keyFormatName);
            keyStore.load(new FileInputStream(this.keyFileName),this.keyPasswordName.toCharArray());
             
            // Create key manager
            KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(this.keyManagerName);
            keyManagerFactory.init(keyStore, this.keyPasswordName.toCharArray());
            KeyManager[] km = keyManagerFactory.getKeyManagers();
             
            // Create trust manager
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(this.keyManagerName);
            trustManagerFactory.init(keyStore);
            TrustManager[] tm = trustManagerFactory.getTrustManagers();
             
            // Initialize SSLContext
            SSLContext sslContext = SSLContext.getInstance("TLSv1");
            sslContext.init(km,  tm, null);
             
            return sslContext;
        } catch (Exception ex){
            ex.printStackTrace();
        }
         
        return null;
    }
}
