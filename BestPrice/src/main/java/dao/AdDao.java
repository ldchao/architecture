package dao;

import Entity.ADs;

import java.util.List;

/**
 * Created by dlydd on 2017/4/14.
 */
public interface AdDao {

    /**
     * 存广告
     * @param aDs
     */
    public void save(ADs aDs);

    /**
     * 删广告
     * @param aDs
     */
    public void delete(ADs aDs);

    /**
     * 更新广告
     * @param aDs
     */
    public void update(ADs aDs);

    /**
     *获得所有广告
     * @return
     */
    public List<ADs> getAll();
}
