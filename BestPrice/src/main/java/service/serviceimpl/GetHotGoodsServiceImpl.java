package service.serviceimpl;

import dao.SearchGoodDao;
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

    @Autowired
    SearchGoodDao searchGoodDao;

    @Override
    public List<GoodVO> getHotGoods() {
//        searchGoodDao.
        return null;
    }
}
