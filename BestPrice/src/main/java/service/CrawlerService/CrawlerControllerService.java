package service.CrawlerService;

import vo.CrawlerConfig;

/**
 * Created by mm on 2017/4/9.
 */
public interface CrawlerControllerService {
    public boolean updateConfig(CrawlerConfig CrawlerConfig);

    public void StartCrawlling();
}
