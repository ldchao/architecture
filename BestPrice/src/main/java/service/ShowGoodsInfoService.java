package service;

import java.util.List;
import vo.GoodInfo;

/**
 * Created by Xuanlin on 2017/4/9.
 */

public interface ShowGoodsInfoService {

    /**
     * 返回列表中属于该商店的所有商品
     * @param shopId
     * @param goodList
     * @return
     */
    public List<GoodInfo> getByShopId(int shopId,List<GoodInfo> goodList);

    /**
     * 根据商品id返回一条商品信息
     * @param goodId
     * @param goodList
     * @return
     */
    public GoodInfo getByGoodId(int goodId,List<GoodInfo> goodList);

    /**
     * 根据商品名称返回一条商品信息
     * @param name
     * @param goodList
     * @return
     */
    public GoodInfo getByGoodName(String name,List<GoodInfo> goodList);


}