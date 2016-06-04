package oguz.network.scanner;

import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class TCPPortScanner {

	private final static int TIMEOUT=300;
	private final static int MAX_PORT=65535;
	
	/**
	 * Scanning port 
	 * @param es
	 * @param ip
	 * @param port
	 * @param timeout
	 * @return if port is open,return true ; else return false
	 */
	
	public static Boolean portIsOpen(final String ip, final int port) {
	
        try {
	          Socket socket = new Socket();
	          socket.connect(new InetSocketAddress(ip, port), TIMEOUT);
	          socket.close();
	          return true;
	    }catch (Exception ex) {
	          return false;
	    }
	}
	
	/**
	 * Scanning all ports
	 * @param ip
	 * @param limit max 65535 
	 * @return list of open ports
	 */
	public static List<Integer> openPorts(final String ip){
		
		List<Integer> portList = new ArrayList<Integer>();
		
		for (int port = 1; port <= MAX_PORT; port++) {
			
			if(portIsOpen(ip, port)){
				portList.add(port);
				System.out.println(port);
			}
		}
		
		return portList;
	}
}
