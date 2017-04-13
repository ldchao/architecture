package dao;

import Entity.BuyRecord;

import java.util.List;

/**
 * Created by dlydd on 2017/4/13.
 */
public interface BuyRecordDao {

    /**
     * 存购买记录
     * @param buyRecord
     */
    public void save(BuyRecord buyRecord);

    /**
     * 根据id
     * 删购买记录
     * @param id
     */
    public void deleteById(int id);

    /**
     * 根据id搜购买记录
     * @param id
     */
    public BuyRecord searchById(int id);

    /**
     * 根据商品id搜购买记录
     * @param productid
     */
    public List<BuyRecord> searchByProductid(int productid);
}
