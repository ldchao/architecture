package service.serviceimpl;

import dao.SearchGoodDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.SearchGoodService;
import service.search_good_shiled.Shield;
import service.search_good_shiled.Shield_Compositor;
import service.search_good_sort.SortStrategy;
import vo.GoodVO;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Administrator on 2017/4/8.
 */

@Service
public class SearchGoodServiceImpl implements SearchGoodService{

    @Autowired
    private SearchGoodDao searchGoodDao;

    private List<GoodVO> goodVOS=null;
    private Shield shield=new Shield_Compositor();

    public Iterator<GoodVO> searchGoods(String key) {
        List<GoodVO> result=new ArrayList<GoodVO>();
        List<String> synonymList=searchGoodDao.searchHomoWord(key);
        for (String synonymKey:synonymList) {
            List<GoodVO> subResult=searchGoodDao.searchGoods(synonymKey);
            result.addAll(subResult);
        }
        return result.iterator();
    }

    public Iterator<GoodVO> shieldGoods(String condition) {
        Class<?> shield_leaf=null;
        List<GoodVO> afterShield=new ArrayList<GoodVO>();
        afterShield.addAll(goodVOS);
        try {
            shield_leaf=Class.forName("service.search_good_shiled."+condition);
            Shield concreteShield=(Shield) shield_leaf.newInstance();
            shield.addShield(concreteShield);
            shield.shieldGood(afterShield);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }finally {
            return afterShield.iterator();
        }
    }

    public Iterator<GoodVO> cancleShield(String condition) {
        Class<?> shield_leaf=null;
        List<GoodVO> afterShield=new ArrayList<GoodVO>();
        afterShield.addAll(goodVOS);
        try {
            shield_leaf=Class.forName("service.search_good_shiled."+condition);
            Shield concreteShield=(Shield) shield_leaf.newInstance();
            shield.removeShield(concreteShield);
            shield.shieldGood(afterShield);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }finally {
            return afterShield.iterator();
        }
    }

    public Iterator<GoodVO> sortResult(String sortRule) {
        Class<?> concreteStrategy = null;
        try {
            concreteStrategy = Class.forName("service.search_good_sort."+sortRule);
            SortStrategy sortStrategy = (SortStrategy) concreteStrategy.newInstance();
            sortStrategy.sort(goodVOS);
        } catch (ClassNotFoundException e) {
            // TODO: 2017/4/9
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } finally {
            return goodVOS.iterator();
        }
    }

    private List<String> getThesaurus(String key){
        return null;
    }
}
