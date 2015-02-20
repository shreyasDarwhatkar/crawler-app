package edu.calstatela.cs454.crawler.crawler_app;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Logger;

import org.slf4j.LoggerFactory;

public class App 
{
	//private static final Logger logger = (Logger) LoggerFactory.getLogger(Crawler.class);
    public static void main( String[] args )
    {
    	String name="http://www.calstatela.edu/";
    	
			try {
				//URL name=new URL("http://www.calstatela.edu/");
				Crawler objcrawlCrawler=new Crawler();
				objcrawlCrawler.getCawling(name);
				
				/*Crawler objcrawlCrawler=new Crawler("http://www.calstatela.edu/");
				ArrayList<String> lststr=objcrawlCrawler.getCawling();
				for(String s :lststr)
				System.out.println(s);
				objcrawlCrawler.getMetadata();*/
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
    }
}
