package service;

import org.springframework.stereotype.Service;

/**
 * Created by marioquer on 2017/4/9.
 * 广告增删改策略类接口
 */

@Service
public interface AdProcessorService {

    /**
     * 增加广告
     * @return boolean
     */
    boolean add();

    /**
     * 更新广告
     * @return boolean
     */
    boolean update();

    /**
     * 删除
     * @return boolean
     */
    boolean delete();


}
