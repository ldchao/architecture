package test;

import Entity.Product;
import dao.daoimpl.ProductDaoImpl;

/**
 * Created by dlydd on 2017/4/13.
 */
public class TestProductDao {

    public static void main(String[] args){
            TestSave();
    }

    public static void TestSave(){
        Product product = new Product();
        product.setId(1);
        product.setTypeid(1);
        product.setSellerid(1);
        product.setPrice(1.0);
        product.setLink("ab");
        ProductDaoImpl productDao =new ProductDaoImpl();
        productDao.save(product);
    }
}
