package dao.daoservice;

import model.User;

import java.util.ArrayList;

/**
 * Created by L.H.S on 2017/4/9.
 */
public interface WaterUserDao {

    // 存储待审核水军
    void saveWater(int userId);

    // 冻结水军用户
    void freezeWaterUser(int userId);

    // 释放水军用户
    void releaseWaterUser(int userId);

    // 获取水军用户
    ArrayList<User> getWater();
}
