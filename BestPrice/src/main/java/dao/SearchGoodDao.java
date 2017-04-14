package dao;

import vo.GoodVO;

import java.util.List;

/**
 * Created by Administrator on 2017/4/9.
 */
public interface SearchGoodDao {

    //根据关键字，检索商品

    /**
     *根据关键字，检索包含key关键字的商品（默认按竞价规则排序）
     * @param key 搜索用关键字
     * @return 满足检索条件的商品条目列表——具体属性见GoodVO
     */
    public List<GoodVO> searchGoods(String key);

    /**
     * 根据关键字，检索所有同义词汇
     * @param key 关键字
     * @return  返回所有同义词的列表
     */
    public List<String> searchHomoWord(String key);

    /**
     * 返回热门商品
     * @return
     */
    public List<GoodVO> getHotGoods();

}
