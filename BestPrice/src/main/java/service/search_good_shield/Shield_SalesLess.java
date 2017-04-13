package service.search_good_shield;

import vo.GoodVO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ldchao on 2017/4/13.
 */
public class Shield_SalesLess implements Shield{
    public void shieldGood(List<GoodVO> list) {
        List<GoodVO> removeList=new ArrayList<GoodVO>();
        for (GoodVO goodVO:list) {
            if(goodVO.getSales_volume()<50){
                removeList.add(goodVO);
            }
        }
        list.removeAll(removeList);
    }

    public void addShield(Shield shield) {

    }

    public void removeShield(Shield shield) {

    }
}
