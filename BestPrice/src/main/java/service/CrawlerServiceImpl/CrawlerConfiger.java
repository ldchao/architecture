package service.CrawlerServiceImpl;

import java.util.ArrayList;

import vo.CrawlerConfig;

public class CrawlerConfiger {
	
	
	
	public ArrayList<CrawlerConfig> getCrawlerConfigs(){
		
		ArrayList<String> strarr=new XMLConfigParser().parseScheduler();
		
		
		ArrayList<CrawlerConfig> cfglist=new ArrayList<CrawlerConfig>();
		
		
		for (String url : strarr) {
			CrawlerConfig config=new CrawlerConfig();
			config.setUrl(url);
			config.setHandler(getHandler(url));
			config.setPersistence(getPersistence(url));
			cfglist.add(config);
		}
		
		
		
		return cfglist;	
	}
	
	
	
	private String getHandler(String url){
		return "Handler java fileName";
	}
	
	private String getPersistence(String url){
		return "Persistence java fileName";
	}
	
}
