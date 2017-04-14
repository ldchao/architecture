package dao.daoimpl;


import Entity.BuyRecord;
import dao.MainConnection;
import dao.PurchaseDao;
import dao.ReadConnection;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import vo.ShoppingCart;
import vo.ShoppingCartItem;

import java.util.Date;
import java.util.*;


/**
 * Created by lois on 2017/4/8.
 */

@Repository
public class PurchaseDaoImpl implements PurchaseDao {

    public List<BuyRecord> getByGoodId(int goodId) {

        BuyRecordDaoImpl buyRecordDao = new BuyRecordDaoImpl();
        return buyRecordDao.searchByProductid(goodId);
    }




//    /**
//     * 创建购买商品记录
//     * @param customerId
//     * @param shoppingCart
//     * @return
//     */
    public List<BuyRecord> create(int customerId, ShoppingCart shoppingCart) {
        List<ShoppingCartItem> shoppingCartItems = shoppingCart.getShoppingCartItems();
        ArrayList<BuyRecord> buyRecords = new ArrayList<BuyRecord>();
        for (ShoppingCartItem shoppingCartItem : shoppingCartItems) {
            BuyRecord buyRecord = new BuyRecord();
            buyRecord.setProductid(shoppingCartItem.getGoodsId());
            buyRecord.setUserid(customerId);
            java.sql.Date date = (java.sql.Date) new Date();
            buyRecord.setBuydate(date);
            buyRecord.setBuynum(shoppingCartItem.getNumber());
            buyRecord.setTotalPrice(shoppingCartItem.getGoodsPrice());
            BuyRecordDaoImpl buyRecordDao = new BuyRecordDaoImpl();
            buyRecordDao.save(buyRecord);
            buyRecords.add(buyRecord);
        }

        return buyRecords;

    }

    public List<BuyRecord> getByCustomerId(int customerId) {
        Session session= ReadConnection.getSession();
        try {
            String hql="from BuyRecord as a where a.userid="+customerId;
            Query query = session.createQuery(hql);
            List aList = query.list();
            ReadConnection.closeSession(session);
            if(aList.size()==0){
                return null;
            }else {
                List<BuyRecord> buyRecords = (List<BuyRecord>) aList;
                return buyRecords;
            }

        }catch (Exception e){
            e.printStackTrace();
            ReadConnection.closeSession(session);
            return  null;
        }
    }

    public BuyRecord getByPurchaseId(int purchaseId) {
        BuyRecordDaoImpl buyRecordDao = new BuyRecordDaoImpl();
        return buyRecordDao.searchById(purchaseId);
    }

    public BuyRecord update(BuyRecord purchase) {
        Session session= MainConnection.getSession();

        Transaction transaction= session.beginTransaction();

        session.update(purchase);

        transaction.commit();
        session.close();
        return purchase;
    }

    /* 要不要这个方法呢QAQ*/
    /*都行，这个不是我写的，我也不是很清楚这个要干嘛*/
    public List<BuyRecord> getTodayByCustomerId(int customerId) {
        Session session= ReadConnection.getSession();
        try {
            String hql="from BuyRecord as a where a.userid="+customerId;
            Query query = session.createQuery(hql);
            List aList = query.list();
            ReadConnection.closeSession(session);
            ArrayList<BuyRecord> buyRecords = new ArrayList<BuyRecord>() ;
            if(aList.size()==0){
                return null;
            }else {
                for(int i=0;i<aList.size();i++){
                    BuyRecord buyRecord = (BuyRecord) aList.get(i);
                    Date date = new Date();
                    java.sql.Date date1=buyRecord.getBuydate();
                    System.out.println(date);
                    System.out.println(buyRecord.getBuydate());
                    if(date1.getYear()==date.getYear()&&
                       date1.getMonth()==date.getMonth()&&
                            date1.getDate()==date.getDate()){
                        System.out.println("sasasa");
                        buyRecords.add(buyRecord);
                    }
                }
                return buyRecords;
            }

        }catch (Exception e){
            e.printStackTrace();
            ReadConnection.closeSession(session);
            return  null;
        }
    }
}
