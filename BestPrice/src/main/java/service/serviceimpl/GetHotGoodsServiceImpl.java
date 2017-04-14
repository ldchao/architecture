package service.serviceimpl;

import dao.SearchGoodDao;
import dao.daoimpl.SearchGoodDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.GetHotGoodsService;
import vo.GoodVO;

import java.util.List;

/**
 * Created by ldchao on 2017/4/14.
 */
@Service
public class GetHotGoodsServiceImpl implements GetHotGoodsService{

    SearchGoodDao searchGoodDao=new SearchGoodDaoImpl();

    @Override
    public List<GoodVO> getHotGoods() {
        System.out.println("sss");
       return searchGoodDao.getHotGoods();
    }
}
