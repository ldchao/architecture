package service.serviceimpl;

import org.springframework.stereotype.Service;
import service.ShowGoodsInfoService;
import java.util.List;

import vo.BuyRecordVO;
import vo.CommentVO;
import vo.GoodInfo;
import vo.GoodVO;


/**
 * Created by Xuanlin on 2017/4/9.
 */

public class ShowGoodsInfoImpl implements ShowGoodsInfoService {


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
