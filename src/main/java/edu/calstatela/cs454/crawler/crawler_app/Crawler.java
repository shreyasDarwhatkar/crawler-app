package edu.calstatela.cs454.crawler.crawler_app;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashSet;

import org.bouncycastle.util.encoders.UrlBase64;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class Crawler {

	String url;
	int count = 0;
	String Dname="";
	public Crawler(String url) {
		super();
		this.url = url;

	}

	public Crawler() {
		super();
	}
	
	public String getDomainName(String paramUrl)
	{
		String DomainName="";
		if(!paramUrl.isEmpty())
		{
			int idx=paramUrl.indexOf(".");
			DomainName=paramUrl.substring(idx+1, paramUrl.length());
			if(DomainName.indexOf("/")!=-1)
			{
				DomainName=DomainName.substring(0,DomainName.length()-1);
			//DomainName.replace('/', ' ');	
			}
			
		}
		
		
		return DomainName.trim();
	}
	HashSet<String> LinksSet = new HashSet<String>();
	void getCawling(String URL) {
		try {
			
			if (LinksSet.contains(URL)) {
				return;
			}else{
				LinksSet.add(URL);
				java.net.URI objurl = new java.net.URI(URL);
				String dname = objurl.getHost();
				dname = getDomainName(dname);
				if (!dname.equalsIgnoreCase(this.Dname))
					return;
				Document doc = Jsoup.connect(URL.toString()).get();
				//System.out.println(URL);
				//count++;
				//System.out.println(URL);
				Elements questions = doc.select("a[href]");
				Elements links = doc.head().getElementsByAttribute("property");
				//System.out.println(links.get(1));
				for (Element link : questions) {
						getCawling(link.attr("abs:href"));
				}
			}
		//printUrl(LinksSet);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (URISyntaxException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
	
	}
	
	void printUrl()
	{
		for(String url:LinksSet)
		{
			System.out.println(url);
		}
	}
}
