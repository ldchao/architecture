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
    public void save(Seller seller);

    /**
     * 删seller
     * @param id
     */
    public void delete(int id);

    /**
     * 根据id搜seller
     * @param id
     * @return
     */
    public Seller search(int id);
}
