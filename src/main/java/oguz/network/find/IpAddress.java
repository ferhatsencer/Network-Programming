package oguz.network.find;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

public class IpAddress {

	public static List<String> getAllIpAddress(String ip) throws UnknownHostException{
		InetAddress[] addresses = InetAddress.getAllByName(ip);
		List<String> list = new ArrayList<String>();
		
		for(InetAddress address:addresses){
			list.add(address.getHostAddress());
		}
		
		return list;
	}
	
/*	public static void main(String[] args) throws UnknownHostException{
		for(String ip : getAllIpAddress("www.google.com") ){
			System.out.println(ip);
		}
	}*/
}
