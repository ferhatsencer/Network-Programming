package oguz.network;

import oguz.network.find.MacAddress;

/**
 * Main 
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	MacAddress address = new MacAddress();
    	System.out.println(address.getIpAddress());
    	System.out.println(address.getMacAddress());
    }
}
