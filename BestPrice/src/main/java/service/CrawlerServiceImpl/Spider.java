package service.CrawlerServiceImpl;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import service.CrawlerService.AbstractStrategy.AbstractHandler;
import service.CrawlerService.AbstractStrategy.AbstractPersistence;
import service.CrawlerService.SpiderService;

import java.io.IOException;

/**
 * Created by mm on 2017/4/9.
 */
public class Spider implements SpiderService{
    AbstractHandler abstractHandler;
    AbstractPersistence abstractPersistence;
    private String url;
    private String target;
    public Spider(){

    }

    public Spider(AbstractHandler abstractHandler, AbstractPersistence abstractPersistence, String url,String target) {
        this.abstractHandler = abstractHandler;
        this.abstractPersistence = abstractPersistence;
        this.url = url;
    }

    public void startCrawlling() {
        abstractPersistence.persist(abstractHandler.handlerHtml(fetch(url)),target);
    }

    public Document fetch(String url) {
        try {
            return Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void setAbstractHandler(AbstractHandler abstractHandler) {
        this.abstractHandler = abstractHandler;
    }

    public void setAbstractPersistence(AbstractPersistence abstractPersistence) {
        this.abstractPersistence = abstractPersistence;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
