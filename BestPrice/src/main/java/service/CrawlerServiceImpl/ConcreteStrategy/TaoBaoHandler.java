package service.CrawlerServiceImpl.ConcreteStrategy;

import org.jsoup.nodes.Document;
import service.CrawlerService.AbstractStrategy.AbstractHandler;
import vo.htmlVO.TaoBao;

/**
 * Created by mm on 2017/4/9.
 */
public class TaoBaoHandler implements AbstractHandler<TaoBao> {
    public TaoBao handlerHtml(Document document) {
        return (new TaoBao());
    }
}
