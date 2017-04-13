package dao.daoimpl;

import Entity.*;
import dao.CheckGoodDao;
import org.springframework.stereotype.Repository;
import vo.GoodVO;

import java.util.ArrayList;

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

        ProductTypeDaoImpl productTypeDao = new ProductTypeDaoImpl();
        ProductType productType = productTypeDao.getProductTypeByID(product.getTypeid());
        goodVO.setDescription(productType.getDescription());
        goodVO.setProduct_name(productType.getName());

        SellerDaoImpl sellerDao = new SellerDaoImpl();
        Seller seller = sellerDao.searchById(product.getSellerid());
        goodVO.setSeller_name(seller.getName());
        goodVO.setPlatform(seller.getPlatform());
        goodVO.setIsJoin(seller.getIsJoin());
        goodVO.setCompetePrice(seller.getCompetePrice());

        BuyRecordDaoImpl buyRecordDao = new BuyRecordDaoImpl();
        ArrayList<BuyRecord> buyRecords =(ArrayList<BuyRecord>)buyRecordDao.searchByProductid(product.getId());
        int sales_volume=0;
        for(BuyRecord buyRecord :buyRecords){
            sales_volume+=buyRecord.getBuynum();
        }
        goodVO.setSales_volume(sales_volume);

        CommentDaoImpl commentDao = new CommentDaoImpl();
        ArrayList<Comment> comments = (ArrayList<Comment>)commentDao.fetchAll(product.getId());
        int comments_volume=comments.size();
        goodVO.setComments_volume(comments_volume);

        return goodVO;
    }
}
