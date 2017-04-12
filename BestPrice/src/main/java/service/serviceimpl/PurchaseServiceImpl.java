package service.serviceimpl;

import Entity.BuyRecord;
import dao.PurchaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.PurchaseService;
import service.payStrategy.PayStrategy;
import vo.ShoppingCart;

import java.util.List;

/**
 * Created by Hanifor on 4/11/2017.
 */
@Service
public class PurchaseServiceImpl implements PurchaseService {

    @Autowired
    private PurchaseDao purchaseDao;

    public BuyRecord create(int customerId, ShoppingCart shoppingCart, PayStrategy strategy) {
        if(strategy.pay()){
            return purchaseDao.create(customerId, shoppingCart);
        }else{
            return null;
        }
    }

    public List<BuyRecord> getByCustomerId(int customerId) {
        return purchaseDao.getByCustomerId(customerId);
    }

    public BuyRecord getByPurchaseId(int purchseId) {
        return purchaseDao.getByPurchaseId(purchseId);
    }

    public BuyRecord update(BuyRecord purchase) {
        return purchaseDao.update(purchase);
    }

    public List<BuyRecord> getTodayByCustomerId(int customerId) {
        return purchaseDao.getTodayByCustomerId(customerId);
    }
}
