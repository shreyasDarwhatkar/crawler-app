package edu.calstatela.cs454.crawler.crawler_app;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.HashSet;
import java.util.UUID;

import javax.net.ssl.SSLHandshakeException;

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
		try {
			int idx = 0;
			if (!paramUrl.isEmpty()) {
				idx = paramUrl.indexOf(".");
				if (idx > 0)
					DomainName = paramUrl.substring(idx + 1, paramUrl.length());
				if (DomainName.indexOf("/") != -1) {
					DomainName = DomainName.substring(0,
							DomainName.length() - 1);
					//DomainName.replace('/', ' ');	
				}

			}
		} catch (Exception e) {
			System.out.println("Exception "+DomainName);
		}
		return DomainName.trim();
	}
	HashSet<String> LinksSet = new HashSet<String>();
	UUID uuid = null;
	void getCawling(String URL) throws SSLHandshakeException {
		try {
			uuid=UUID.randomUUID();
			if(URL.toLowerCase().contains(".pdf"))
			{
				System.out.println("PDF "+URL.toLowerCase());
			URL website = new URL(URL);
			ReadableByteChannel rbc = Channels.newChannel(website.openStream());
			FileOutputStream fos = new FileOutputStream(".\\CrawlerStorage\\"+uuid.toString()+".pdf");
			fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
			return;
			}
			if(count>2)
				return;
			
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
				System.out.println(URL);
				Elements questions = doc.select("a[href]");
				
				for(Element meta : doc.select("meta")) {
				    System.out.println("Name: " + meta.attr("name") + " - Content: " + meta.attr("content"));
				}
				for (Element link : questions) {
						getCawling(link.attr("abs:href"));
						
				}
				count++;
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
