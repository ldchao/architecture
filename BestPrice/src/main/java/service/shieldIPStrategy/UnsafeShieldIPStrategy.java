package service.shieldIPStrategy;

import Entity.Ip;
import dao.ShieldIPDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Hanifor on 4/11/2017.
 */
public class UnsafeShieldIPStrategy implements ShieldIPStrategy {
    @Autowired
    private ShieldIPDao shieldIPDao;

    /**
     * 是否为屏蔽ip
     * @param IP
     * @return
     */
    public boolean isUnsafe(String IP) {
        List<Ip> ips = shieldIPDao.query();
        for (Ip ip:ips) {
            if(ip.getIp().equals(IP)){
                return true;
            }
        }
        return false;
    }
}
