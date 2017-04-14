package service.CrawlerServiceImpl.ConcreteStrategy;

import Entity.Product;
import Entity.ProductType;
import Entity.Seller;
import dao.ProductDao;
import dao.ProductTypeDao;
import dao.SellerDao;
import org.springframework.beans.factory.annotation.Autowired;
import service.CrawlerService.AbstractStrategy.AbstractPersistence;
import vo.CrawlerVO;

import java.util.ArrayList;

/**
 * Created by mm on 2017/4/14.
 */
public class JingDongPersistence extends AbstractPersistence<ArrayList<CrawlerVO>> {
    @Autowired
    ProductDao productDao;
    @Autowired
    ProductTypeDao productTypeDao;
    @Autowired
    SellerDao sellerDao;

    public void persist(ArrayList<CrawlerVO> crawlerVOs,String target) {
        ProductType productType=productTypeDao.getProductTypeByName(target);
//        Seller seller=sellerDao.searchById();
        Product product=new Product();
        for (CrawlerVO crawlerVO:crawlerVOs
             ) {
            product.setLink(crawlerVO.getLink());
            product.setPrice(crawlerVO.getPrice());
            product.setProductTypeByTypeid(productType);
            product.setSellerid(1);
            productDao.save(product);
        }

    }
}
