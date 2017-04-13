package test;

import Entity.BuyRecord;
import dao.daoimpl.PurchaseDaoImpl;

import java.sql.Date;
import java.util.List;

/**
 * Created by dlydd on 2017/4/13.
 */
public class TestPurchaseDao {

    public static void main(String args[]){
        //testSearchByCustomerid();
        //testUpdate();
        testGetToday();
    }

    public static void testSearchByCustomerid(){
        PurchaseDaoImpl purchaseDao = new PurchaseDaoImpl();
        List<BuyRecord> buyRecords = purchaseDao.getByCustomerId(1);
        for(BuyRecord buyRecord:buyRecords){
            System.out.println(buyRecord);
        }
    }

    public static void testUpdate(){
        BuyRecord buyRecord = new BuyRecord();
        buyRecord.setId(1);
        buyRecord.setBuynum(2);
        buyRecord.setTotalPrice(2.0);
        buyRecord.setBuydate(new Date(2017-1900,03,13));
        buyRecord.setUserid(1);
        buyRecord.setProductid(1);
        PurchaseDaoImpl purchaseDao = new PurchaseDaoImpl();
        purchaseDao.update(buyRecord);
    }

    public static void testGetToday(){
        PurchaseDaoImpl purchaseDao=new PurchaseDaoImpl();
        List<BuyRecord> buyRecords =purchaseDao.getTodayByCustomerId(1);
        for(BuyRecord buyRecord:buyRecords){
            System.out.println(buyRecord);
        }
    }
}
