import dao.SensitiveWordDao;
import dao.ShieldIPDao;
import dao.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import service.GetHotGoodsService;
import service.SearchGoodService;
import service.UserService;
import service.serviceimpl.GetHotGoodsServiceImpl;
import vo.GoodVO;
import vo.UserVO;

import java.util.List;

/**
 * Created by ldchao on 2017/4/13.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/dispatcher-servlet.xml" })
public class GoodTest {

    @Autowired
    SearchGoodService searchGoodService;
    @Autowired
    GetHotGoodsService getHotGoodsService;
    @Autowired
    SensitiveWordDao sensitiveWordDao;
    @Autowired
    ShieldIPDao shieldIPDao;

    @Test
    public void searchGoods(){
//        shieldIPDao.query();
//        sensitiveWordDao.getSentiveWord();
//        List<GoodVO> list=getHotGoodsService.getHotGoods();
//        for (GoodVO g:list) {
//            System.out.println(g.getProduct_name());
//        }

    }
}
