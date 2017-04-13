package dao.daoimpl;

import Entity.Product;
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
        return goodVO;
    }
}
