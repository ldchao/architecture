package service.search_good_shield;

import vo.GoodVO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/4/9.
 */
public class Shield_NotJoin implements Shield{
    public void shieldGood(List<GoodVO> list) {

        List<GoodVO> removeList=new ArrayList<GoodVO>();
        for (GoodVO goodVO:list) {
            if(goodVO.getIsJoin()==-1){
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
