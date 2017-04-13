package test;

import dao.CheckGoodDao;
import dao.daoimpl.CheckGoodDaoImpl;
import vo.GoodVO;

/**
 * Created by dlydd on 2017/4/13.
 */
public class TestCheckGoodDao {
    public static void main(String[] args){
        testGetGood();
    }

    public static void testGetGood(){
        CheckGoodDaoImpl checkGoodDao =new CheckGoodDaoImpl();
        GoodVO goodVO=checkGoodDao.getGoodByGoodId(1);
        System.out.println(goodVO.getComments_volume());
        System.out.println(goodVO.getCompetePrice());
        System.out.println(goodVO.getSales_volume());
    }
}
