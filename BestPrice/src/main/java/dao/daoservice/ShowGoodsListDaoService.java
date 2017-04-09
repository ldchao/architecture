package dao.daoservice;

import java.util.List;
import vo.GoodInfo;

/**
 * Created by Xuanlin on 2017/4/9.
 */

public interface ShowGoodsListDaoService {


    public List<GoodInfo> getAllGoodList();


    public List<GoodInfo> getByShopId(int shopId);


    public GoodInfo getByGoodId(int goodId);


    public GoodInfo getByGoodName(String name);


    public GoodInfo update(GoodInfo goodinfo);

}
t;