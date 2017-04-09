package service.search_good_shiled;

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

    }

    public void addShield(Shield shield) {
         shieldList.add(shield);
    }

    public void removeShield(Shield shield) {
         shieldList.remove(shield);
    }
}
