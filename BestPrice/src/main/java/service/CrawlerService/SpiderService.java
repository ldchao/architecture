package service.CrawlerService;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.util.ArrayList;

/**
 * Created by mm on 2017/4/9.
 */
public interface SpiderService {
    public void startCrawlling();

    public Document fetch(String url);
}
