package service.CrawlerService;

import vo.CrawlerConfig;

import java.util.ArrayList;

/**
 * Created by mm on 2017/4/9.
 */
public interface CrawlerControllerService {
    public boolean updateConfig(ArrayList<CrawlerConfig> crawlerConfigs);

    public void StartCrawlling();
}
