package service.CrawlerService;

import org.jsoup.nodes.Document;

/**
 * Created by mm on 2017/4/9.
 */
public interface SpiderService {
    public void startCrawlling();

    public Document fetch(String url);
}
