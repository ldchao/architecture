package test;

import dao.daoimpl.SearchGoodDaoImpl;
import vo.GoodVO;

import java.util.List;

/**
 * Created by dlydd on 2017/4/14.
 */
public class TestHotGoods {

    public static void main(String[] args){
        testHotGoods();
    }

    public static void testHotGoods(){
        SearchGoodDaoImpl searchGoodDao = new SearchGoodDaoImpl();
        List<GoodVO> goodVOs = searchGoodDao.getHotGoods();
        for(GoodVO goodVO:goodVOs){
            System.out.println(goodVO);
        }
    }
}
