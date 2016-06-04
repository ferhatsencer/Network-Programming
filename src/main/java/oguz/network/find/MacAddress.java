package oguz.network.find;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

/*
 * Find current ip and mac address
 */
public class MacAddress {
	
	/*
	 * Get local ip address
	 */
	public String getIpAddress(){
		
		String ip = null;
		
		try {
			ip = InetAddress.getLocalHost().toString();
		} catch (UnknownHostException e) {
			System.out.println("This local ip is unkown");
		}
		
		return ip;
	}
	
	/*
	 * Get mac address
	 */
	public String getMacAddress(){
		
		NetworkInterface network;
		byte[] macAddress = null;
		try {
			network = NetworkInterface.getByInetAddress(InetAddress.getLocalHost());
			macAddress = network.getHardwareAddress();
		} catch (SocketException e) {
			System.out.println("Socket Exception: "+e.toString());
		} catch (UnknownHostException e) {
			System.out.println("Unkown Host Exception: "+e.toString());
		}
			
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < macAddress.length; i++) {
			stringBuilder.append(String.format("%02X%s", macAddress[i], (i < macAddress.length - 1) ? "-" : ""));		
		}
		
		return stringBuilder.toString();
	}
	
	
}
