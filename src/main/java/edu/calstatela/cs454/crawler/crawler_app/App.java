package edu.calstatela.cs454.crawler.crawler_app;


public class App 
{
	//private static final Logger logger = (Logger) LoggerFactory.getLogger(Crawler.class);
    public static void main( String[] args )
    {
    	String name="http://ocean.pcwerk.com/~jtran/search/a.html";
			try {
				//URL name=new URL("http://www.calstatela.edu/");
				Crawler objcrawlCrawler=new Crawler();
				objcrawlCrawler.Dname=objcrawlCrawler.getDomainName(name);
				objcrawlCrawler.getCawling(name);
				//objcrawlCrawler.printUrl();
			} catch (Exception e) {
				// TODO Auto-generated catch block 
				e.printStackTrace();
			}		
    }
}
