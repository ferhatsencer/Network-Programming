package oguz.network.generate;

import java.util.Random;

public class GenerateRandomIpAddress {
	
	/*
	 * Generate Random Ip Address
	 */
	public static String generate(){
		Random r = new Random();
		return r.nextInt(256) + "." + r.nextInt(256) + "." + r.nextInt(256) + "." + r.nextInt(256);
	}
}
