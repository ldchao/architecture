package dao.daoimpl;

import Entity.Product;
import Entity.Seller;
import dao.CheckGoodDao;
import org.springframework.stereotype.Repository;
import vo.GoodVO;

/**
 * Created by ldchao on 2017/4/12.
 */
@Repository
public class CheckGoodDaoImpl implements CheckGoodDao{
    public GoodVO getGoodByGoodId(int goodId) {
        GoodVO goodVO = new GoodVO();
        goodVO.setId(goodId);
        ProductDaoImpl productDao = new ProductDaoImpl();
        Product product = productDao.searchById(goodId);
        goodVO.setPrice(product.getPrice());
        SellerDaoImpl sellerDao = new SellerDaoImpl();
        Seller seller = sellerDao.searchById(product.getSellerid());
        goodVO.setSeller_name(seller.getName());
        goodVO.setPlatform(seller.getPlatform());
        goodVO.setIsJoin(seller.getIsJoin());
        goodVO.setCompetePrice(seller.getCompetePrice());

        return goodVO;
    }
}
