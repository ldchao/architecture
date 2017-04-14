package service.CrawlerServiceImpl;


import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import vo.PatternAndPlatform;



public class XMLConfigParser {
	public static final String filepath="src/main/resources/crawlerConfig.xml";
	
	public ArrayList<PatternAndPlatform> parseConfig(){
		DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder db = factory.newDocumentBuilder();
			Document doc = db.parse(filepath);  
			
			
			ArrayList<PatternAndPlatform> pAndPlatforms=new ArrayList<PatternAndPlatform>();
			
			ArrayList<String> strarr=new ArrayList<String>();
			
			NodeList timeList = doc.getElementsByTagName("URLS"); 
			
			Node time=(Node) timeList.item(0);

			NodeList urllist=time.getChildNodes();
			
			
			for (int i = 0; i < urllist.getLength(); i++) {
				Node url=(Node) urllist.item(i);
				
				if (url.getFirstChild()==null) {
					continue;
				}
				
				
				String aString=url.getFirstChild().getNodeValue();
				
				
				String plat=url.getAttributes().item(0).getNodeValue();
				
				PatternAndPlatform patternAndPlatform=new PatternAndPlatform();
				
				patternAndPlatform.setUrlpattern(aString);
				
				//add platform
				
				patternAndPlatform.setPlatform(plat);
				
				pAndPlatforms.add(patternAndPlatform);
			}
			
			

			
			return pAndPlatforms;
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return null;
	}
	
}
