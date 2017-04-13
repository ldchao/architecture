package service.serviceimpl;

import Entity.BuyRecord;
import dao.PurchaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.PurchaseService;
import service.payStrategy.PayStrategy;
import vo.BuyRecordVO;
import vo.ShoppingCart;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hanifor on 4/11/2017.
 */
@Service
public class PurchaseServiceImpl implements PurchaseService {

    @Autowired
    private PurchaseDao purchaseDao;

    public BuyRecordVO create(int customerId, ShoppingCart shoppingCart, PayStrategy strategy) {
        if(strategy.pay()){
            BuyRecord br = purchaseDao.create(customerId, shoppingCart);
            BuyRecordVO brv = new BuyRecordVO();
            brv.update(br);
            return brv;
        }else{
            return null;
        }
    }

    public List<BuyRecordVO> getByCustomerId(int customerId) {
        List<BuyRecord> brs = purchaseDao.getByCustomerId(customerId);
        List<BuyRecordVO> brvs = new ArrayList<BuyRecordVO>();
        for (BuyRecord br: brs) {
            BuyRecordVO brv = new BuyRecordVO();
            brv.update(br);
            brvs.add(brv);
        }
        return brvs;
    }

    public BuyRecordVO getByPurchaseId(int purchseId) {
        BuyRecord br = purchaseDao.getByPurchaseId(purchseId);
        BuyRecordVO brv = new BuyRecordVO();
        brv.update(br);
        return brv;
    }

    public BuyRecordVO update(BuyRecordVO purchase) {
        BuyRecord br = purchaseDao.update(purchase.makeBuyRecord());
        BuyRecordVO brv = new BuyRecordVO();
        brv.update(br);
        return brv;
    }

    public List<BuyRecordVO> getTodayByCustomerId(int customerId) {
        List<BuyRecord> brs = purchaseDao.getTodayByCustomerId(customerId);
        List<BuyRecordVO> brvs = new ArrayList<BuyRecordVO>();
        for (BuyRecord br: brs) {
            BuyRecordVO brv = new BuyRecordVO();
            brv.update(br);
            brvs.add(brv);
        }
        return brvs;
    }
}
