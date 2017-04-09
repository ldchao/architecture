package service.search_good_shiled;

import vo.GoodVO;

import java.util.List;

/**
 * Created by Administrator on 2017/4/9.
 */
public interface Shield {

    //屏蔽商品
    public void shieldGood(List<GoodVO> list);

    //增加屏蔽条件
    public void addShield(Shield shield);

    //删除屏蔽条件
    public void removeShield(Shield shield);

}
