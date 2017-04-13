package dao;

import Entity.Ip;

import java.util.List;

/**
 * Created by lois on 2017/4/9.
 */
public interface ShieldIPDao {

    /**
     * 向屏蔽ip表内添加特定IP
     * @param ip
     * @return
     */
    boolean add(Ip ip);

    /**
     * 删除屏蔽IP
     * @param ip
     * @return
     */
    boolean delete(Ip ip);

    /**
     * 更新屏蔽IP
     * @param ip
     * @return
     */
    boolean update(Ip ip);

    /**
     * 获取被屏蔽ip
     * @return
     */
    List<Ip> query();
}

