package service.CrawlerService;

/**
 * Created by mm on 2017/4/9.
 */
public interface CrawlerScheduleService {
  //when you need to start crawler,call this
  	public void startControlCrawler();


  	public void forceUpdate();
  	public void stop();
}
