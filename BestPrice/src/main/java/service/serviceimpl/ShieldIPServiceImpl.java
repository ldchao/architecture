package service.serviceimpl;

import Entity.Ip;
import dao.ShieldIPDao;
import dao.daoimpl.ShieldIPDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.ShieldIPService;
import java.util.List;
import java.util.Observable;

/**
 * Created by Hanifor on 4/11/2017.
 */
@Service
public class ShieldIPServiceImpl extends Observable implements ShieldIPService {
//    @Autowired
    private ShieldIPDao shieldIPDao=new ShieldIPDaoImpl();

    public ShieldIPServiceImpl(){}

    public boolean add(Ip ip) {
        boolean res = shieldIPDao.add(ip);
        if(res){
            this.notifyObservers("+" + ip.getIp());
        }
        return res;
    }

    public boolean delete(Ip ip) {
        boolean res = shieldIPDao.delete(ip);
        if(res){
            this.notifyObservers("-" + ip.getIp());
        }
        return res;
    }

    public List<Ip> query(){
        return shieldIPDao.query();
    }

    public boolean update(Ip ip) {
        return shieldIPDao.update(ip);
    }
}
