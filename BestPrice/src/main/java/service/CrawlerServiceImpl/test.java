package service.CrawlerServiceImpl;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import service.CrawlerService.AbstractStrategy.AbstractHandler;

import java.io.IOException;

/**
 * Created by mm on 2017/4/10.
 */
public class test {
    public static void main(String[] args){
        DangDang("绿豆");
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

    public static void Handle(String target){
        Document document=fetch("https://search.jd.com/Search?keyword="+target+"&enc=utf-8&wq="+target);
        Elements elements1= document.getElementsByAttributeValue("class","gl-warp clearfix").first().select("li[data-sku]");
        for (Element e1:
                elements1) {
            Element t1 = e1.getElementsByAttributeValue("class", "p-price").first().getElementsByTag("i").first();
            Element t2 = e1.getElementsByAttributeValue("class", "p-name p-name-type-2").first().getElementsByTag("a").first();
            if (t1 == null || t2 == null)
                continue;
            String price = t1.text();
            String name = t2.attr("title");
            String url = t2.attr("href");
            if (price==null||name==null||url==null){
                continue;
            }else if (url.contains("item.jd.com")){
                url="http:"+url;
            }else {
                continue;
            }

            String store=fetch(url).getElementsByAttributeValue("class","crumb-wrap").first().
                    getElementsByAttributeValue("class","contact fr clearfix").first().
                    getElementsByTag("a").first().text();

            System.out.println(name+" "+price+" "+url+" "+store);


        }
    }

    public static void DangDang(String target){
        Document document=fetch("http://search.dangdang.com/?key="+target+"&act=input");
        Elements elements=document.getElementsByAttributeValue("class","bigimg cloth_shoplist").first().getElementsByTag("li");
        for (Element element:elements
             ) {
            String price=element.getElementsByAttributeValue("class","price").first().text();
            String name=element.getElementsByAttributeValue("class","name").first().getElementsByTag("a").first().attr("title");
            String link=element.getElementsByAttributeValue("class","name").first().getElementsByTag("a").first().attr("href");
            String store="当当自营";
            if(element.getElementsByAttributeValue("class","link").first()!=null){
                store=element.getElementsByAttributeValue("class","link").first().text();
            }
            System.out.println(name+" "+price+" "+store+" "+link);
        }


    }
}
