package service;

import service.payStrategy.PayStrategy;
import vo.BuyRecordVO;
import vo.ShoppingCart;

import java.util.List;

/**
 * Created by lois on 2017/4/8.
 *
 * 购买商品
 */

public interface PurchaseService {

    /**
     * 创建购买信息记录
     * 结算购物车的商品
     * @param customerId
     * @param shoppingCart
     * @return
     */
    public List<BuyRecordVO> create(int customerId, ShoppingCart shoppingCart, PayStrategy strategy);

    /**
     * 可以通过顾客的id得到购买记录
     * @param customerId
     * @return
     */
    public List<BuyRecordVO> getByCustomerId(int customerId);


    /**
     * 可以通过购买记录单号获得购买信息
     * @param purchseId
     * @return
     */
    public BuyRecordVO getByPurchaseId(int purchseId);

    /**
     * 更新购买记录
     * @param purchase
     * @return
     */
    public BuyRecordVO update(BuyRecordVO purchase);

    /**
     * 获得当日购买信息
     * @param customerId
     * @return
     */
    public List<BuyRecordVO> getTodayByCustomerId(int customerId);
}
