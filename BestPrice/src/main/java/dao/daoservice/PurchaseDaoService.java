package dao.daoservice;

import Entity.Purchase;
import vo.ShoppingCart;

import java.util.List;

/**
 * Created by lois on 2017/4/8.
 *
 * 购买商品
 */

public interface PurchaseDaoService {

    /**
     * 创建购买信息记录
     * 结算购物车的商品
     * @param customerId
     * @param shoppingCart
     * @return
     */
    public Purchase create(int customerId, ShoppingCart shoppingCart);

    /**
     * 可以通过顾客的id得到购买记录
     * @param customerId
     * @return
     */
    public List<Purchase> getByCustomerId(int customerId);


    /**
     * 可以通过购买记录单号获得购买信息
     * @param purchseId
     * @return
     */
    public Purchase getByPurchaseId(int purchseId);

    /**
     * 更新购买记录
     * @param purchase
     * @return
     */
    public Purchase update(Purchase purchase);

    /**
     * 获得当日购买信息
     * @param customerId
     * @return
     */
    public List<Purchase> getTodayByCustomerId(int customerId);
}
