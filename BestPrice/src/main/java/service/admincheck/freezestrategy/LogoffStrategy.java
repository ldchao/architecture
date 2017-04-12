package service.admincheck.freezestrategy;

import dao.WaterUserDao;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by L.H.S on 2017/4/9.
 */
public class LogoffStrategy implements FreezeStrategy {

    @Autowired
    private WaterUserDao waterUserDao;

    public void freezeUser(int userId) {

        waterUserDao.freezeWaterUser(userId);
    }

}
