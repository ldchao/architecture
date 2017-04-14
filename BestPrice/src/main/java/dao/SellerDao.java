package dao;

import Entity.Seller;

/**
 * Created by dlydd on 2017/4/13.
 */
public interface SellerDao {

    /**
     * 存Seller
     * @param seller
     */
    public int save(Seller seller);

    /**
     * 删seller
     * @param id
     */
    public boolean deleteById(int id);

    /**
     * 根据id搜seller
     * @param id
     * @return
     */
    public Seller searchById(int id);
    
    /**
     * 根据name搜seller
     * @param name
     * @return
     */
    public Seller searchByName(String name);
    
//    /**
//     * 获得所有seller
//     * @param name
//     * @return
//     */
//    public Seller getAllSellers();
    
    
}
