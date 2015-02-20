package edu.calstatela.cs454.crawler.crawler_app;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

import javax.swing.text.html.HTMLDocument.Iterator;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;



import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;


public class Crawler {

	String url;
	int count = 0;

	public Crawler(String url) {
		super();
		this.url = url;

	}

	public Crawler() {
		super();
	}

	void getCawling(String URL) {
		try {
		if(count==10)
			return;
		Document doc = Jsoup.connect(URL.toString()).get();
		System.out.println(URL);
		count++;
			//System.out.println(URL);
		Elements questions = doc.select("a[href]");
		Elements links = doc.head().getElementsByAttribute("property");
		//System.out.println(links.get(1));
		for(Element link: questions){
			if(link.attr("href").contains("calstatela.edu"))
				getCawling(link.attr("abs:href"));
		}
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	
	/*try {
		String crawlStorageFolder ="F:\\Shreyas\\MS Study\\SearchEngineOptimization";
		int numberOfCrawlers = 1;

		CrawlConfig config = new CrawlConfig();
		config.setCrawlStorageFolder(crawlStorageFolder);
		config.setMaxDepthOfCrawling(2);
		config.setIncludeBinaryContentInCrawling(false);
		
		PageFetcher pageFetcher = new PageFetcher(config);
		RobotstxtConfig robotstxtConfig = new RobotstxtConfig();
		RobotstxtServer robotstxtServer = new RobotstxtServer(robotstxtConfig, pageFetcher);
		CrawlController controller = new CrawlController(config, pageFetcher, robotstxtServer);
		controller.addSeed("http://www.ics.uci.edu/~lopes/");
        controller.addSeed("http://www.ics.uci.edu/~welling/");
        controller.addSeed("http://www.ics.uci.edu/");

		 controller.start(MyCrawler.class, numberOfCrawlers);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
*/	    

	}
}
