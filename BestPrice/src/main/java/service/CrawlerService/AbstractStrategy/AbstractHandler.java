package service.CrawlerService.AbstractStrategy;

import org.jsoup.nodes.Document;

/**
 * Created by mm on 2017/4/9.
 */
public interface AbstractHandler<T> {
    public Object handlerHtml(Document document);
}
