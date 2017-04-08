package service;

import vo.GoodVO;

import java.util.Iterator;

/**
 * Created by Administrator on 2017/4/8.
 */
public interface SearchGoodService {

    //根据关键字key
    public Iterator<GoodVO> searchGoods(String key);

    //根据选择的规则屏蔽特定商品
    public Iterator<GoodVO> shieldGoods(String condition);

    //根据选择的规则取消屏蔽特定商品
    public Iterator<GoodVO> cancleShield(String condition);

    //根据选择的排序策略对搜索结果进行排序
    public Iterator<GoodVO> sortResult(String sortRule);

}
