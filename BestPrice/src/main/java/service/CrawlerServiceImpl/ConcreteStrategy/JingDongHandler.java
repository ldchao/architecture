package service.CrawlerServiceImpl.ConcreteStrategy;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import service.CrawlerService.AbstractStrategy.AbstractHandler;
import vo.CrawlerVO;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by mm on 2017/4/13.
 */
public class JingDongHandler implements AbstractHandler<CrawlerVO>{
    public ArrayList<CrawlerVO> handlerHtml(Document document) {
        ArrayList<CrawlerVO> arrayList=new ArrayList<CrawlerVO>();
        try {
            Elements elements1 = document.getElementsByAttributeValue("class", "gl-warp clearfix").first().select("li[data-sku]");
            for (Element e1 :
                    elements1) {
                try {
                    Element t1 = e1.getElementsByAttributeValue("class", "p-price").first().getElementsByTag("i").first();
                    Element t2 = e1.getElementsByAttributeValue("class", "p-name p-name-type-2").first().getElementsByTag("a").first();
                    if (t1 == null || t2 == null)
                        continue;
                    String price = t1.text();
                    String name = t2.attr("title");
                    String url = t2.attr("href");
                    if (price == null || name == null || url == null) {
                        continue;
                    } else if (url.contains("item.jd.com")) {
                        url = "http:" + url;
                    } else {
                        continue;
                    }

                    String store = fetch(url).getElementsByAttributeValue("class", "crumb-wrap").first().
                            getElementsByAttributeValue("class", "contact fr clearfix").first().
                            getElementsByTag("a").first().text();

                    CrawlerVO crawlerVO = new CrawlerVO();
                    crawlerVO.setName(name);
                    crawlerVO.setLink(url);
                    crawlerVO.setPrice(Double.parseDouble(price));
                    crawlerVO.setStore(store);
                    arrayList.add(crawlerVO);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return  arrayList;
    }

    public static Document fetch(String url) {
        try {
            return Jsoup.connect(url).data("query", "Java").userAgent("Mozilla")
                    .cookie("auth", "token")
                    .post();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
