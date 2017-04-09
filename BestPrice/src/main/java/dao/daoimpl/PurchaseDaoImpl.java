package dao.daoimpl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import Entity.Purchase;
import Entity.PurchaseItem;
import dao.daoservice.PurchaseDaoService;
import vo.ShoppingCart;
import vo.ShoppingCartItem;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by lois on 2017/4/8.
 */

@Repository
public class PurchaseDaoImpl implements PurchaseDaoService {

    @Autowired
    private SessionFactory sessionFactory;

    //TODO customer相关
//    @Autowired
//    private CustomerDao customerDao;


    /**
     * 创建购买商品记录
     * @param customerId
     * @param shoppingCart
     * @return
     */
    public Purchase create(int customerId, ShoppingCart shoppingCart) {

//        Session session = sessionFactory.getCurrentSession();

        //TODO Customer相关
//        Customer customer = customerDao.findById(customerId);

        Purchase purchase = new Purchase();

        purchase.setCustomerId(customerId);
        purchase.setBuyTime(new Timestamp(System.currentTimeMillis()));
        //TODO Goods相关
//        purchase.setDiscount();

        session.save(purchase);
        session.flush();

        double originalTotal = 0;

        Set<PurchaseItem> items = new HashSet<PurchaseItem>();
        for (ShoppingCartItem item: shoppingCart.getShoppingCartItems()){
            PurchaseItem purchaseItem = new PurchaseItem();
            purchaseItem.setPurchase(purchase);
            purchaseItem.setNumber(item.getNumber());
            purchaseItem.setPrice(item.getGoodsPrice());

            //TODO Goods相关
//            Goods goods = new Goods();
//            goods.setId(item.getGoodsId());
//            purchaseItem.setGoods(goods);

            originalTotal += item.getGoodsPrice()*item.getNumber();

            items.add(purchaseItem);

            //TODO 商品需要减少库存 （如果有库存的话？）

        }

        purchase.setPurchaseItems(items);
        purchase.setOriginalTotal(originalTotal);
        purchase.setActualTotal(originalTotal*purchase.getDiscount());


        session.save(purchase);
        session.flush();

        return purchase;
    }

    public List<Purchase> getByCustomerId(int customerId) {
//        Session session = sessionFactory.getCurrentSession();
//        //TODO  query语句内容
//        Query query = session.createQuery("");
//        query.setInteget("customerId",customerId);
//        return query.list();
    }

    public Purchase getByPurchaseId(int purchaseId) {
//        Session session = sessionFactory.getCurrentSession();
//        //TODO query语句内容
//        Query query = session.createQuery("");
//        query.setInteger("id", purchaseId);
//        if (query.list() == null || query.list().size() == 0) {
//            return null;
//        } else {
//            return (Purchase) query.list().get(0);
//        }
    }

    public Purchase update(Purchase purchase) {
        Session session = sessionFactory.getCurrentSession();
        session.save(purchase);
        session.flush();
        return purchase;
    }

    /* 要不要这个方法呢QAQ*/
    public List<Purchase> getTodayByCustomerId(int customerId) {

        return null;
    }
}
