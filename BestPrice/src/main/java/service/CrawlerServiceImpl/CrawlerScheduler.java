package service.CrawlerServiceImpl;



import java.util.ArrayList;

import service.CrawlerService.CrawlerControllerService;
import service.CrawlerService.CrawlerScheduleService;
import vo.CrawlerConfig;

public class CrawlerScheduler implements CrawlerScheduleService,Runnable{
	
	private static boolean isStart=true;
	
	private static CrawlerScheduler scheduler;
	
	private static Thread thread;
	
	private CrawlerScheduler(){
		
	}
	
	public static CrawlerScheduler getInstance(){
		if(scheduler==null){
			scheduler=new CrawlerScheduler();
			
		}
		return scheduler;	
	}
	
	
	public void startControlCrawler() {
		if (isStart) {
			System.out.println("crawler is already started,If you want to force start,call forceStart()");
			return;
		}
		
		
		thread=new Thread(this);
		thread.start();
	}

	public void forceUpdate() {
		// TODO Auto-generated method stub
		
	}

	public void run() {
		XMLScheduleParser parser=new XMLScheduleParser();
		
		while (isStart) {
			
		
		String timegap=parser.parseScheduler();
		
		long timemills=(long) (Double.parseDouble(timegap)*60*1000);
		
		try {
			//TODO
			
			// start crawling
			
			CrawlerControllerService csControllerService=new CrawlerController();
			
			CrawlerConfiger cfger=new CrawlerConfiger();
			ArrayList<CrawlerConfig> list= cfger.getCrawlerConfigs();
			
			csControllerService.updateConfig(list);
			
			csControllerService.StartCrawlling();
			System.out.println("Crawler is starting");
			Thread.sleep(timemills);
			
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}
		
		
	}

	public void stop() {
		if (!isStart) {
			System.out.println("crawler is not started yet");
			return;
		}
		isStart=false;
		
	}


}
