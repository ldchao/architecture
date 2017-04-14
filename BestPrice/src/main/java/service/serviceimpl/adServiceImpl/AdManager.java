package service.serviceimpl.adServiceImpl;

import Entity.ADs;
import dao.AdDao;
import dao.daoimpl.AdDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import service.AdProcessorService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by marioquer on 2017/4/9.
 */
public class AdManager {

    @Autowired
    AdProcessorService adProcessorService;
    AdDao adDao =new AdDaoImpl();
    //observerList<>

    //设定广告处理策略类
    public void setAdProcessor(AdProcessorService ad){
        adProcessorService = ad;
    }


    // 获取广告
    public ArrayList<ADs> get(){ return (ArrayList<ADs>)adDao.getAll();}

    public boolean add(){
        return false;
    }

    //更新广告
    public boolean update(){
        return false;
    }

    //删除广告
    public boolean delete(){
        return false;
    }

    //增加观察者
    public void addObserver(){}

    //删除观察者
    public void removeObserver(){}

    //通知观察者
    public void notifyObserver(){}
}
