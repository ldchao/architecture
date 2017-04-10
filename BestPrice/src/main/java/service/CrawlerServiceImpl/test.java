package service.CrawlerServiceImpl;

import service.CrawlerService.AbstractStrategy.AbstractHandler;

/**
 * Created by mm on 2017/4/10.
 */
public class test {
    public static void main(String[] args){
        System.out.print("h");
        try {
            AbstractHandler abstractHandler= (AbstractHandler) Class.forName("123").newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
