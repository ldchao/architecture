package dao;

import Entity.Product;

/**
 * Created by dlydd on 2017/4/12.
 */
public interface ProductDao {

    /**
     * 保存商品
     * @param product
     */
    public void save(Product product);

    /**
     * 通过id删除商品
     * @param id
     */
    public void delete(int id);

    /**
     * 通过id搜索商品
     * @param id
     */
    public Product search(int id);
}
