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

        for (Shield shield:shieldList) {
            shield.shieldGood(list);
        }
    }

    public void addShield(Shield shield) {
         shieldList.add(shield);
    }

    public void removeShield(Shield shield) {
        Shield needRemove=null;
        for (Shield s :shieldList) {
            if(s.getClass()==shield.getClass()){
                needRemove=s;
                break;
            }
        }
        shieldList.remove(needRemove);
    }

    public static void main(String[] args) {
        Shield_Compositor shield_compositor=new Shield_Compositor(new ArrayList<Shield>());
        Shield shield=new Shield_NotJoin();
        shield_compositor.addShield(shield);
        Shield shield1=new Shield_NotJoin();
        shield_compositor.removeShield(shield1);
        System.out.println(shield_compositor.shieldList.size());
    }
}
