package service;

import vo.GoodVO;

import java.util.Iterator;

/**
 * Created by Administrator on 2017/4/8.
 */
public interface SearchGoodService {

    /**
     * 根据关键字key搜索满足条件的商品条目
     * @param key 搜索用的关键字
     * @return  搜索到的所有相关的商品列表
     */
    public Iterator<GoodVO> searchGoods(String key);

    /**
     * 根据选择的规则屏蔽特定商品
     * @param condition 屏蔽规则
     * @return 根据屏蔽规则屏蔽后的列表
     */
    public Iterator<GoodVO> shieldGoods(String condition);

    /**
     * 根据选择的规则取消屏蔽特定商品
     * @param condition 屏蔽规则
     * @return 取消屏蔽规则后的列表
     */
    public Iterator<GoodVO> cancleShield(String condition);

    /**
     * 根据选择的排序策略对搜索结果进行排序
     * @param sortRule 排序规则
     * @return 根据排序策略重新排序后的商品
     */
    public Iterator<GoodVO> sortResult(String sortRule);

}
