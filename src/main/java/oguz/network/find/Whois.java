package oguz.network.find;

import java.io.IOException;
import java.net.SocketException;

import org.apache.commons.net.whois.WhoisClient;

/**
 * Basit bir whois sorgusunu icerir
 * @author oguzcanpamuk
 *
 */

public class Whois {

	public static String getWhois(String domainName) throws SocketException, IOException{
		
		WhoisClient whois = new WhoisClient();
		
		whois.connect(WhoisClient.DEFAULT_HOST);
		String result = whois.query("=" + domainName);
		
		whois.disconnect();
		
		return result;
	}
	
	public static void main(String[] args) throws SocketException, IOException{
		System.out.println(getWhois("oguzpamuk.com"));
	}
}
