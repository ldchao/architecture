package service.serviceimpl.adServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import service.AdProcessorService;

/**
 * Created by marioquer on 2017/4/9.
 */
public class AdManager {

    @Autowired
    AdProcessorService adProcessorService;

    //observerList<>

    //设定广告处理策略类
    public void setAdProcessor(AdProcessorService ad){
        adProcessorService = ad;
    }

    //增加广告
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
