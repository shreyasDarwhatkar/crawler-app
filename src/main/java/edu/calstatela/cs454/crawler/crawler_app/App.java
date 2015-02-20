package edu.calstatela.cs454.crawler.crawler_app;


public class App 
{
	//private static final Logger logger = (Logger) LoggerFactory.getLogger(Crawler.class);
    public static void main( String[] args )
    {
    	String name="http://www.calstatela.edu/";
    	
			try {
				//URL name=new URL("http://www.calstatela.edu/");
				Crawler objcrawlCrawler=new Crawler();
				objcrawlCrawler.Dname=objcrawlCrawler.getDomainName("http://www.mit.edu/");
				objcrawlCrawler.getCawling("http://www.mit.edu/");
				//objcrawlCrawler.printUrl();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
    }
}
