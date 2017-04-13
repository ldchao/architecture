package test;

import Entity.ProductType;
import dao.daoimpl.ProductTypeDaoImpl;

/**
 * Created by dlydd on 2017/4/13.
 */
public class TestProductTypeDaoImpl {
    public static void main(String[] args){
        TestSave();
    }

    public static void TestSave(){
        ProductType productType =new ProductType();
        productType.setId(1);
        productType.setDescription("ab");
        productType.setName("IT");
        ProductTypeDaoImpl productTypeDao = new ProductTypeDaoImpl();
        productTypeDao.addProductType(productType);
    }
}
