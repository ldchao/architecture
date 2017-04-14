package service.CrawlerServiceImpl;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import service.CrawlerService.AbstractStrategy.AbstractHandler;
import service.CrawlerService.AbstractStrategy.AbstractPersistence;
import service.CrawlerService.SpiderService;
import vo.CrawlerVO;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by mm on 2017/4/9.
 */
public class Spider implements SpiderService{
    AbstractHandler abstractHandler;
    AbstractPersistence abstractPersistence;
    public String url;
    private String target;
    public Spider(){

    }

    public Spider(AbstractHandler abstractHandler, AbstractPersistence abstractPersistence, String url,String target) {
        this.abstractHandler = abstractHandler;
        this.abstractPersistence = abstractPersistence;
        this.url = url;
        this.target=target;
    }

    public void startCrawlling() {
        ArrayList<CrawlerVO> arrayList= (ArrayList<CrawlerVO>) abstractHandler.handlerHtml(fetch(url));
        abstractPersistence.registerShop(arrayList);
        abstractPersistence.persist(arrayList,target);
    }

    public Document fetch(String url) {
        try {
            return Jsoup.connect(url).data("query", "Java").userAgent("Mozilla")
                    .cookie("auth", "token")
                    .post();
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
