package service.CrawlerServiceImpl.ConcreteStrategy;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import service.CrawlerService.AbstractStrategy.AbstractHandler;
import vo.CrawlerVO;

import java.util.ArrayList;

/**
 * Created by mm on 2017/4/14.
 */
public class DangDangHandler implements AbstractHandler<CrawlerVO> {
    public ArrayList<CrawlerVO> handlerHtml(Document document) {
        ArrayList<CrawlerVO> arrayList=new ArrayList<CrawlerVO>();
        try {
            Elements elements=document.getElementsByAttributeValue("class","bigimg cloth_shoplist").first().getElementsByTag("li");
            for (Element element:elements
                    ) {
                try {
                    String price=element.getElementsByAttributeValue("class","price").first().text();
                    String name=element.getElementsByAttributeValue("class","name").first().getElementsByTag("a").first().attr("title");
                    String link=element.getElementsByAttributeValue("class","name").first().getElementsByTag("a").first().attr("href");
                    String store="当当自营";
                    if(element.getElementsByAttributeValue("class","link").first()!=null){
                        store=element.getElementsByAttributeValue("class","link").first().text();
                    }

                    CrawlerVO crawlerVO=new CrawlerVO();
                    crawlerVO.setLink(link);
                    crawlerVO.setName(name);
                    crawlerVO.setPrice(Double.parseDouble(price.substring(1)));
                    crawlerVO.setStore(store);
                    System.out.println(crawlerVO.getName()+" "+crawlerVO.getPrice()+" "+crawlerVO.getStore()+" "+crawlerVO.getLink());
                    arrayList.add(crawlerVO);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return arrayList;
    }
}
