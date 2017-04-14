package service.CrawlerServiceImpl;

import org.springframework.stereotype.Service;
import service.CrawlerService.AbstractStrategy.AbstractHandler;
import service.CrawlerService.AbstractStrategy.AbstractPersistence;
import service.CrawlerService.CrawlerConfigHandlerService;
import vo.CrawlerConfig;

import java.util.ArrayList;

/**
 * Created by mm on 2017/4/10.
 */
public class CrawlerConfigHandler implements CrawlerConfigHandlerService {
    public ArrayList<Spider> handleConfig(ArrayList<CrawlerConfig> crawlerConfigs) {
        ArrayList<Spider> spiders=new ArrayList<Spider>();
        for (CrawlerConfig crawlerConfig:crawlerConfigs
             ) {
            try {
                AbstractHandler abstractHandler= (AbstractHandler) Class.forName("service.CrawlerServiceImpl.ConcreteStrategy."+crawlerConfig.getHandler()).newInstance();
                AbstractPersistence abstractPersistence=(AbstractPersistence) Class.forName("service.CrawlerServiceImpl.ConcreteStrategy."+crawlerConfig.getPersistence()).newInstance();
                spiders.add(new Spider(abstractHandler, abstractPersistence, crawlerConfig.getUrl(),crawlerConfig.getProductName()));
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return spiders;
    }
}
