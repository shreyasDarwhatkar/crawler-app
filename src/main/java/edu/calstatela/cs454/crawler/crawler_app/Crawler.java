package edu.calstatela.cs454.crawler.crawler_app;
import java.awt.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.extractor.ExtractorFactory;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.HttpHeaders;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.sax.BodyContentHandler;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;

import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.html.HtmlParser;
import org.xml.sax.SAXException;

import com.sun.syndication.feed.atom.Link;
public class Crawler {
	String url;

	public Crawler(String url) {
		super();
		this.url = url;
	}
	
	ArrayList<String> getCawling()
	{
		ArrayList<String> lsturl = new ArrayList<String>();
		try {
			String temp="";
			URL customUrl = new URL(this.url);
			BufferedReader br = new BufferedReader(new InputStreamReader(customUrl.openStream()));
			while((temp=br.readLine())!=null)
			{
				//System.out.println(temp);
			org.apache.tika.sax.Link link=new org.apache.tika.sax.Link(null,temp, null,null);
			//System.out.println(link.getUri());
			if (link.getUri().contains("<a "))
			{
				System.out.println(link.getUri());
			}
			
			/* BodyContentHandler contenthandler=new BodyContentHandler();
			    Metadata metadata=new Metadata();
			    ParseContext context=new ParseContext();
			    Parser tikaParser=new AutoDetectParser();;
				//tikaParser.parse(temp,contenthandler,metadata,context);
			    System.out.println(metadata.get(HttpHeaders.CONTENT_TYPE));
			}*/
			
		} 
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return lsturl;
		
	}
	
	public void getMetadata()
	{
		File file=new File("test.txt");
	      //Parser method parameters
	      try {
			Parser parser = new AutoDetectParser();
			  BodyContentHandler handler = new BodyContentHandler();
			  Metadata metadata = new Metadata();
			  FileInputStream inputstream = new FileInputStream(file);
			  ParseContext context = new ParseContext();
			  
			  parser.parse(inputstream, handler, metadata, context);
			  System.out.println(handler.toString());

			  //getting the list of all meta data elements 
			  String[] metadataNames = metadata.names();
		

			  for(String name : metadataNames) {		        
			     System.out.println(name + ": " + metadata.get(name));
			  }
			 
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TikaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}