package service.serviceimpl;

import Entity.Ip;
import dao.ShieldIPDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.ShieldIPService;
import service.shieldIPStrategy.ShieldIPStrategy;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hanifor on 4/11/2017.
 */
@Service
public class ShieldIPServiceImpl implements ShieldIPService {
    @Autowired
    private ShieldIPDao shieldIPDao;

    private List<ShieldIPStrategy> strategies;

    public ShieldIPServiceImpl(){
        strategies = new ArrayList<ShieldIPStrategy>();
    }

    public boolean checkIP(HttpServletRequest request) {
        String ip = this.getIp(request);
        for (ShieldIPStrategy strategy:strategies) {
            if(strategy.isUnsafe(ip)){
                return false;
            }
        }

        return true;
    }

    public boolean add(Ip ip) {
        return shieldIPDao.add(ip);
    }

    public boolean delete(Ip ip) {
        return shieldIPDao.delete(ip);
    }

    public List<Ip> query(){
        return shieldIPDao.query();
    }

    public boolean update(Ip ip) {
        return shieldIPDao.update(ip);
    }

    private String getIp(HttpServletRequest request){
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
}
