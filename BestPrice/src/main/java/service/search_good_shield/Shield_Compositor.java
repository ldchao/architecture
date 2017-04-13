package service.search_good_shield;

import vo.GoodVO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/4/9.
 */
public class Shield_Compositor implements Shield{

    List<Shield> shieldList;

    public Shield_Compositor(){
        shieldList=new ArrayList<Shield>();
    }

    public Shield_Compositor(List<Shield> shieldList) {
        this.shieldList = shieldList;
    }

    public void shieldGood(List<GoodVO> list) {

        for (Shield shield:shieldList) {
            shield.shieldGood(list);
        }
    }

    public void addShield(Shield shield) {
         shieldList.add(shield);
    }

    public void removeShield(Shield shield) {
        Shield needRemove=null;
        String name=shield.getClass().getName();
        for (Shield s :shieldList) {
            if(s.getClass().getName().equals(name)){
                needRemove=s;
                break;
            }
        }
        shieldList.remove(needRemove);
    }

}
