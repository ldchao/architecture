package service;

import java.util.List;
import vo.GoodInfo;

/**
 * Created by Xuanlin on 2017/4/9.
 */

public interface ShowGoodsInfoService {

    public List<GoodInfo> getByShopId(int shopId,List<GoodInfo> goodList);


    public GoodInfo getByGoodId(int goodId,List<GoodInfo> goodList);


    public GoodInfo getByGoodName(String name,List<GoodInfo> goodList);

}