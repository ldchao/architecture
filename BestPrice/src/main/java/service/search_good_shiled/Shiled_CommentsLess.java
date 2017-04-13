package service.search_good_shiled;

import vo.GoodVO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ldchao on 2017/4/13.
 */
public class Shiled_CommentsLess implements Shield{
    public void shieldGood(List<GoodVO> list) {
        List<GoodVO> removeList=new ArrayList<GoodVO>();
        for (GoodVO goodVO:list) {
            if(goodVO.getComments_volume()<50){
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
