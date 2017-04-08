package service.serviceimpl;

import service.SearchGoodService;
import vo.GoodVO;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Administrator on 2017/4/8.
 */
public class SearchGoodServiceImpl implements SearchGoodService{

    private List<GoodVO> goodVOS=null;

    public Iterator<GoodVO> searchGoods(String key) {
        return null;
    }

    public Iterator<GoodVO> shieldGoods(String condition) {
        return null;
    }

    public Iterator<GoodVO> cancleShield(String condition) {
        return null;
    }

    public Iterator<GoodVO> sortResult(String sortRule) {
        return null;
    }
}
