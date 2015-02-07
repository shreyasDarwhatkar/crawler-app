package edu.calstatela.cs454.crawler.crawler_app;

import java.util.ArrayList;

public class App 
{
    public static void main( String[] args )
    {
    	Crawler objcrawlCrawler=new Crawler("http://en.wikipedia.org/wiki/George_W._Bush");
    	/*ArrayList<String> lststr=objcrawlCrawler.getCawling();
    	for(String s :lststr)
    	System.out.println(s);*/
    	objcrawlCrawler.getMetadata();
    }
}
