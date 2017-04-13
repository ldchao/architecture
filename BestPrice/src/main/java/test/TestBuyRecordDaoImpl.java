package test;

import Entity.BuyRecord;
import dao.daoimpl.BuyRecordDaoImpl;

import java.sql.Date;
import java.util.ArrayList;

/**
 * Created by dlydd on 2017/4/13.
 */
public class TestBuyRecordDaoImpl {
    public static void main(String[] args){

        //testSave();
        //testDelete();
        testSearchByProductid();
    }

    public static void testSave(){
        BuyRecord buyRecord = new BuyRecord();
        buyRecord.setId(1);
        buyRecord.setProductid(1);
        buyRecord.setUserid(1);
        Date date = new Date(2017-1900,03,13);
        buyRecord.setBuydate(date);
        buyRecord.setBuynum(1);
        buyRecord.setTotalPrice(1.0);
        int productid=buyRecord.getProductid();
        System.out.println(productid);
        BuyRecordDaoImpl buyRecordDao = new BuyRecordDaoImpl();
        buyRecordDao.save(buyRecord);
    }

    public static  void testDelete(){
        BuyRecordDaoImpl buyRecordDao = new BuyRecordDaoImpl();
        buyRecordDao.deleteById(1);
    }

    public static void testSearchByProductid(){
        ArrayList<BuyRecord> buyRecords = new ArrayList<BuyRecord>();
        BuyRecordDaoImpl buyRecordDao = new BuyRecordDaoImpl();
        buyRecords=(ArrayList<BuyRecord>) buyRecordDao.searchByProductid(1);
        for(BuyRecord buyRecord:buyRecords){
            System.out.println(buyRecord);
        }
    }
}
