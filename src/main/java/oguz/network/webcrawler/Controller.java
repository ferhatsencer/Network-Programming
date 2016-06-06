package oguz.network.webcrawler;


import java.util.ArrayList;
import java.util.List;

import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;


/*
 * 	Web Crawler controller class
 * 
 */
public class Controller {

	
	/*
	 * Crawler'in ayarlari static degiskenler uzerinden yapiliyor(path,thread vs)
	 */
	private final static String CRAWLER_STORAGE_FOLDER="/Users/oguzcanpamuk/Documents/crawler";
	private final static int NUMBER_OF_CRAWLERS = 10;
	private static CrawlController controller;
	private static String webUrl;
	private static List<String> allUrl;
	
	
	/*
	 * Ayarlar set ediliyor
	 */
	public static void init() throws Exception{
		setAllUrl(new ArrayList<String>());
        CrawlConfig config = new CrawlConfig();
        config.setCrawlStorageFolder(CRAWLER_STORAGE_FOLDER);
        PageFetcher pageFetcher = new PageFetcher(config);
        RobotstxtConfig robotstxtConfig = new RobotstxtConfig();
        RobotstxtServer robotstxtServer = new RobotstxtServer(robotstxtConfig, pageFetcher);
        controller = new CrawlController(config, pageFetcher, robotstxtServer);
	}
	
	
	/*
	 * Crawler'i calistiran method
	 */
	public static void start(String url) throws Exception{
		init();
		setWebUrl(url);
		System.out.println("Start Web Crawler");
		controller.addSeed(url);
		controller.start(Crawler.class, NUMBER_OF_CRAWLERS);
	}
	
	
	/*
	 * Crawler kullanici tarafindan bu methodla durdurulabilir
	 */
	public static void stop(){
		
		if(!controller.isFinished()){
			controller.shutdown();
			System.out.println("Stop Web Crawler");
		}
	}

	public static String getWebUrl() {
		return webUrl;
	}

	public static void setWebUrl(String webUrl) {
		Controller.webUrl = webUrl;
	}

	public static List<String> getAllUrl() {
		return allUrl;
	}

	public static void setAllUrl(List<String> allUrl) {
		Controller.allUrl = allUrl;
	}
	
	/*
	public static void main(String[] args) throws Exception{
		Controller.start("http://oguzpamuk.com");
		System.err.println(Controller.getAllUrl());
	}*/
}
