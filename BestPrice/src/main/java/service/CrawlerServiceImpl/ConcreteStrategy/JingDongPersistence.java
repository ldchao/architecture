package service.CrawlerServiceImpl.ConcreteStrategy;

import Entity.Product;
import Entity.ProductType;
import Entity.Seller;
import dao.ProductDao;
import dao.ProductTypeDao;
import dao.SellerDao;
import dao.daoimpl.ProductDaoImpl;
import dao.daoimpl.ProductTypeDaoImpl;
import dao.daoimpl.SellerDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import service.CrawlerService.AbstractStrategy.AbstractPersistence;
import vo.CrawlerVO;

import java.util.ArrayList;

/**
 * Created by mm on 2017/4/14.
 */
public class JingDongPersistence extends AbstractPersistence<ArrayList<CrawlerVO>> {
    ProductDao productDao=new ProductDaoImpl();
    ProductTypeDao productTypeDao=new ProductTypeDaoImpl();
    SellerDao sellerDao=new SellerDaoImpl();

    @Override
    public void registerShop(ArrayList<CrawlerVO> crawlerVOS) {
        ArrayList<Seller> arrayList=new ArrayList<>();
        arrayList.addAll((ArrayList<Seller>)sellerDao.getAllSellersByPlatform("jingdong"));
        ArrayList<String> haveBeenStored=new ArrayList<>();
        for (Seller seller:arrayList
             ) {
            if (!haveBeenStored.contains(seller.getName()))
            haveBeenStored.add(seller.getName());
        }
        System.out.println("已存商铺"+haveBeenStored.size());
        for (CrawlerVO crawlerVO:crawlerVOS){
            if (!haveBeenStored.contains(crawlerVO.getStore())) {
                Seller seller = new Seller();
                seller.setName(crawlerVO.getStore());
                seller.setCompetePrice(1.0);
                seller.setIsJoin(0);
                seller.setPlatform("jingdong");
                sellerDao.save(seller);
                haveBeenStored.add(crawlerVO.getStore());
            }
        }

        System.out.println("登记商铺"+haveBeenStored.size());
    }

    public void persist(ArrayList<CrawlerVO> crawlerVOs, String target) {
        ProductType productType=productTypeDao.getProductTypeByName(target);
        System.out.println(target);
        Product product=new Product();
        for (CrawlerVO crawlerVO:crawlerVOs
             ) {

            product.setLink(crawlerVO.getLink());
            product.setPrice(crawlerVO.getPrice());
            product.setProductTypeByTypeid(productType);
            product.setSellerid(sellerDao.searchByName(crawlerVO.getStore()).getId());
            product.setTypeid(productType.getId());
            productDao.save(product);
            System.out.println("存储");
        }


    }
}
