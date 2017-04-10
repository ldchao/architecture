package service.CrawlerServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import service.CrawlerService.CrawlerConfigHandlerService;
import service.CrawlerService.CrawlerControllerService;
import service.CrawlerService.CrawlerScheduleService;
import vo.CrawlerConfig;

import java.util.ArrayList;

/**
 * Created by mm on 2017/4/9.
 */
public class CrawlerController implements CrawlerControllerService,Runnable{
    private CrawlerConfig crawlerConfig;
    private CrawlerScheduleService crawlerSchedule;

    @Autowired
    private CrawlerConfigHandlerService crawlerConfigHandler;

    private boolean activated;
    private ArrayList<Spider> spiders;
    public CrawlerController(){
        activated=false;
        spiders=new ArrayList<Spider>();
        Thread thread=new Thread(this);
        thread.start();
    }
    public boolean updateConfig(CrawlerConfig crawlerConfig) {
        this.crawlerConfig=crawlerConfig;
        if (this.crawlerConfig!=null&&this.crawlerConfig.checkNotNull()){
            this.spiders=crawlerConfigHandler.handleConfig(this.crawlerConfig);
            return true;
        }else {
            return false;
        }
    }

    public void StartCrawlling() {
        activated=true;
    }

    public void run() {
        while (true){
            try {
                Thread.sleep(1000);
                if (activated==true){
                    for (Spider spider :
                            spiders) {
                        spider.startCrawlling();
                    }
                    activated=false;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
