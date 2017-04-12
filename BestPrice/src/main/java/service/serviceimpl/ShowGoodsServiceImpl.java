package service.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import service.ShowGoodsService;
import java.util.List;

import vo.BuyRecordVO;
import vo.CommentVO;
import vo.GoodVO;


/**
 * Created by Xuanlin on 2017/4/9.
 */

public class ShowGoodsServiceImpl implements ShowGoodsService {

    @Autowired


    public GoodVO getByGoodId(int goodId) {
        return null;
    }

    public List<CommentVO> getCommentByGoodId(int goodId) {
        return null;
    }

    public List<BuyRecordVO> getByShopId(int goodId) {
        return null;
    }
}
