package dao.daoservice;

/**
 * Created by L.H.S on 2017/4/9.
 */
public interface WaterUserService {

    // 存储待审核水军
    void saveWater(int userId);

    // 冻结水军用户
    void freezeWaterUser(int userId, int days);

    // 释放水军用户
    void releaseWaterUser(int userId);
}
