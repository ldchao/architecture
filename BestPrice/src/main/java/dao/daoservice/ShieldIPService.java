package dao.daoservice;

import Entity.ShieldIP;

/**
 * Created by lois on 2017/4/9.
 */
public interface ShieldIPService {

    /**
     * 向屏蔽ip表内添加特定IP
     * @param ip
     * @return
     */
    public boolean add(ShieldIP ip);

    /**
     * 删除屏蔽IP
     * @param ip
     * @return
     */
    public boolean delete(ShieldIP ip);

    /**
     * 更新屏蔽IP
     * @param ip
     * @return
     */
    public boolean update(ShieldIP ip);

    /**
     * 通过相关信息检索IP（？）
     * @param key
     * @return
     */
    public boolean query(String key);



}

