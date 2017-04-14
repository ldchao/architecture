package service.serviceimpl.adServiceImpl;

import Entity.ADs;
import dao.AdDao;
import dao.daoimpl.AdDaoImpl;
import service.AdProcessorService;

/**
 * Created by marioquer on 2017/4/9.
 */
public class TopAdProcessor implements AdProcessorService{

    AdDao adDao =new AdDaoImpl();
    //position

    // 获取广告
    public ADs get(){return adDao.getAll().get(0);}
    public boolean add() {
        return false;
    }

    public boolean update() {
        return false;
    }

    public boolean delete() {
        return false;
    }
}
