package service.CrawlerService;

import service.CrawlerServiceImpl.Spider;
import vo.CrawlerConfig;

import java.util.ArrayList;

/**
 * Created by mm on 2017/4/9.
 */
public interface CrawlerConfigHandlerService {
    public ArrayList<Spider> handleConfig(ArrayList<CrawlerConfig> crawlerConfigs);
}
