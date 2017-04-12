package dao.daoimpl;


import dao.PurchaseDao;
import org.springframework.stereotype.Repository;
import Entity.Purchase;
import vo.ShoppingCart;
import java.util.List;


/**
 * Created by lois on 2017/4/8.
 */

@Repository
public class PurchaseDaoImpl implements PurchaseDao {

    public List<Purchase> getByGoodId(int goodId) {
        return null;
    }

    //    @Autowired
//    private SessionFactory sessionFactory;

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
         return null;
//        Session session = sessionFactory.getCurrentSession();

        //TODO Customer相关
//        Customer customer = customerDao.findById(customerId);

//        Purchase purchase = new Purchase();
//
//        purchase.setCustomerId(customerId);
//        purchase.setBuyTime(new Timestamp(System.currentTimeMillis()));
//        //TODO Goods相关
//        purchase.setDiscount();
//
//        session.save(purchase);
//        session.flush();
//
//        double originalTotal = 0;
//
//        Set<PurchaseItem> items = new HashSet<PurchaseItem>();
//        for (ShoppingCartItem item: shoppingCart.getShoppingCartItems()){
//            PurchaseItem purchaseItem = new PurchaseItem();
//            purchaseItem.setPurchase(purchase);
//            purchaseItem.setNumber(item.getNumber());
//            purchaseItem.setPrice(item.getGoodsPrice());
//
//            //TODO Goods相关
////            Goods goods = new Goods();
////            goods.setId(item.getGoodsId());
////            purchaseItem.setGoods(goods);
//
//            originalTotal += item.getGoodsPrice()*item.getNumber();
//
//            items.add(purchaseItem);
//
//            //TODO 商品需要减少库存 （如果有库存的话？）
//
//        }
//
//        purchase.setPurchaseItems(items);
//        purchase.setOriginalTotal(originalTotal);
//        purchase.setActualTotal(originalTotal*purchase.getDiscount());
//
//
//        session.save(purchase);
//        session.flush();
//
//        return purchase;
    }

    public List<Purchase> getByCustomerId(int customerId) {
//        Session session = sessionFactory.getCurrentSession();
//        //TODO  query语句内容
//        Query query = session.createQuery("");
//        query.setInteget("customerId",customerId);
//        return query.list();
        return null;
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
        return null;
    }

    public Purchase update(Purchase purchase) {
//        Session session = sessionFactory.getCurrentSession();
//        session.save(purchase);
//        session.flush();
//        return purchase;
        return null;
    }

    /* 要不要这个方法呢QAQ*/
    public List<Purchase> getTodayByCustomerId(int customerId) {

        return null;
    }
}
