package service.CrawlerServiceImpl;

import java.util.ArrayList;

import dao.ProductTypeDao;
import dao.daoimpl.ProductTypeDaoImpl;
import vo.CrawlerConfig;
import vo.PatternAndPlatform;

public class CrawlerConfiger {
	
	
	
	public ArrayList<CrawlerConfig> getCrawlerConfigs(){
		
		ArrayList<PatternAndPlatform> patterns=new XMLConfigParser().parseConfig();
		
		
		ArrayList<CrawlerConfig> cfglist=new ArrayList<CrawlerConfig>();
		
		ProductTypeDao productTypeDao=new ProductTypeDaoImpl();
		
		
		ArrayList<String> namelist=productTypeDao.getAllProductName();
		
		
		
		
		for (String pname : namelist) {
			
			for (PatternAndPlatform patternandplat : patterns) {
				CrawlerConfig config=new CrawlerConfig();
				
				
				config.setProductName(pname);
				config.setPlatform(patternandplat.getPlatform());
				
				config.setHandler(getHandler(patternandplat.getPlatform()));
				config.setPersistence(getPersistence(patternandplat.getPlatform()));
				
				
				String url=patternandplat.getUrlpattern();
				
				url=url.replaceAll("@@", pname);
				
				System.out.println(patternandplat.getPlatform());
				
//				System.out.println(url+";;;;;"+config.getProductName());
				
				config.setUrl(url);
				cfglist.add(config);
			}
			
		}
		
		return cfglist;	
	}
	
	
	
	private String getHandler(String platform){
		String handler="";
		if(platform.equals("dangdang")){
			handler="DangDangHandler";
		}else if(platform.equals("jingdong")){
			handler="JingDongHandler";
		}
		return handler;
		
	}
	
	private String getPersistence(String platform){
		String persistence="";
		if(platform.equals("dangdang")){
			persistence="DangDangPersistence";
		}else if(platform.equals("jingdong")){
			persistence="JingDongPersistence";
		}
		return persistence;
	}
	
}
