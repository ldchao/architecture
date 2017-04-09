package dao.daoimpl;

import Entity.Purchase;
import dao.daoservice.PurchaseDaoService;
import vo.ShoppingCart;

import java.util.List;

/**
 * Created by lois on 2017/4/8.
 */


public class PurchaseDaoImpl implements PurchaseDaoService {


    public Purchase create(int customerId, ShoppingCart shoppingCart) {
        return null;
    }

    public List<Purchase> getByCustomerId(int customerId) {
        return null;
    }

    public Purchase getByPurchaseId(int purchseId) {
        return null;
    }

    public Purchase update(Purchase purchase) {
        return null;
    }

    public List<Purchase> getTodayByCustomerId(int customerId) {
        return null;
    }
}
