package service.serviceimpl;

import dao.SearchGoodDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.SearchGoodService;
import service.errorHandle.ErrorBase;
import service.errorHandle.ErrorHandler;
import service.search_good_shield.Shield;
import service.search_good_shield.Shield_Compositor;
import service.search_good_sort.SortStrategy;
import service.serviceimpl.errorHandle.CommError;
import service.serviceimpl.errorHandle.GuiSysHandle;
import vo.GoodVO;

import java.util.ArrayList;
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

    public List<GoodVO> searchGoods(String key) {
        goodVOS=new ArrayList<GoodVO>();
        List<String> synonymList=searchGoodDao.searchHomoWord(key);
        for (String synonymKey:synonymList) {
            List<GoodVO> subResult=searchGoodDao.searchGoods(synonymKey);
            goodVOS.addAll(subResult);
        }
        return goodVOS;
    }

    public List<GoodVO> shieldGoods(String condition) {
        Class<?> shield_leaf=null;
        List<GoodVO> afterShield=new ArrayList<GoodVO>();
        afterShield.addAll(goodVOS);
        try {
            shield_leaf=Class.forName("service.search_good_shield."+condition);
            Shield concreteShield=(Shield) shield_leaf.newInstance();
            shield.addShield(concreteShield);
            shield.shieldGood(afterShield);
        } catch (Exception e) {
            e.printStackTrace();
            ErrorHandler errorHandler=new GuiSysHandle();
            ErrorBase errorBase=new CommError();
            errorHandler.announceError(errorBase);
        }finally {
            return afterShield;
        }
    }

    public List<GoodVO> cancleShield(String condition) {
        Class<?> shield_leaf=null;
        List<GoodVO> afterShield=new ArrayList<GoodVO>();
        afterShield.addAll(goodVOS);
        try {
            shield_leaf=Class.forName("service.search_good_shield."+condition);
            Shield concreteShield=(Shield) shield_leaf.newInstance();
            shield.removeShield(concreteShield);
            shield.shieldGood(afterShield);
        } catch (Exception e) {
            e.printStackTrace();
            ErrorHandler errorHandler=new GuiSysHandle();
            ErrorBase errorBase=new CommError();
            errorHandler.announceError(errorBase);
        }finally {
            return afterShield;
        }
    }

    public List<GoodVO> sortResult(String sortRule) {
        Class<?> concreteStrategy = null;
        try {
            concreteStrategy = Class.forName("service.search_good_sort."+sortRule);
            SortStrategy sortStrategy = (SortStrategy) concreteStrategy.newInstance();
            sortStrategy.sort(goodVOS);
        } catch (Exception e) {
            e.printStackTrace();
            ErrorHandler errorHandler=new GuiSysHandle();
            ErrorBase errorBase=new CommError();
            errorHandler.announceError(errorBase);
        } finally {
            return goodVOS;
        }
    }


}
