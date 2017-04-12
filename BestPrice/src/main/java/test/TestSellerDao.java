package test;

import Entity.Seller;
import dao.daoimpl.SellerDaoImpl;

/**
 * Created by dlydd on 2017/4/13.
 */
public class TestSellerDao {
    public static void main(String[] args){
        TestSave();
    }

    public static void TestSave(){
        Seller seller = new Seller();
        seller.setId(1);
        seller.setName("lenovo");
        seller.setPlatform("taobao");
        seller.setIsJoin(0);
        seller.setCompetePrice(10.0);
        SellerDaoImpl sellerDao =new SellerDaoImpl();
        sellerDao.save(seller);
    }
}
