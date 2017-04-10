package dao.daoimpl;

import dao.SearchGoodDao;
import org.springframework.stereotype.Repository;
import vo.GoodVO;

import java.util.List;

/**
 * Created by Administrator on 2017/4/10.
 */
@Repository
public class SearchGoodDaoImpl implements SearchGoodDao{
    public List<GoodVO> searchGoods(String key) {
        return null;
    }

    public List<String> searchHomoWord(String key) {
        return null;
    }
}
