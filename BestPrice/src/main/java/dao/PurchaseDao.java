package dao;

import Entity.BuyRecord;
import vo.ShoppingCart;

import java.util.List;

/**
 * Created by lois on 2017/4/8.
 *
 * 购买商品
 */

public interface PurchaseDao {

//    /**
//     * 创建购买信息记录
//     * 结算购物车的商品
//     * @param customerId
//     * @param shoppingCart
//     * @return
//     */
    public List<BuyRecord> create(int customerId, ShoppingCart shoppingCart);

    /**
     * 可以通过顾客的id得到购买记录
     * @param customerId
     * @return
     */
    public List<BuyRecord> getByCustomerId(int customerId);

    /**
     * 可以通过商品id得到购买记录
     * @param goodId
     * @return
     */
    public List<BuyRecord> getByGoodId(int goodId);

    /**
     * 可以通过购买记录单号获得购买信息
     * @param purchseId
     * @return
     */
    public BuyRecord getByPurchaseId(int purchseId);

    /**
     * 更新购买记录
     * @param purchase
     * @return
     */
    public BuyRecord update(BuyRecord purchase);

    /**
     * 获得当日购买信息
     * @param customerId
     * @return
     */
    public List<BuyRecord> getTodayByCustomerId(int customerId);
}
