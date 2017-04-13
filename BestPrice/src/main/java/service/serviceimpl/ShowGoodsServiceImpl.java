package service.serviceimpl;

import Entity.BuyRecord;
import Entity.Comment;
import dao.CheckGoodDao;
import dao.CommentDao;
import dao.PurchaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.ShowGoodsService;

import java.util.ArrayList;
import java.util.List;

import vo.BuyRecordVO;
import vo.CommentVO;
import vo.GoodVO;


/**
 * Created by Xuanlin on 2017/4/9.
 */
@Service
public class ShowGoodsServiceImpl implements ShowGoodsService {

    @Autowired
    CheckGoodDao checkGoodDao;
    @Autowired
    CommentDao commentDao;
    @Autowired
    PurchaseDao purchaseDao;

    public GoodVO getByGoodId(int goodId) {
        return checkGoodDao.getGoodByGoodId(goodId);
    }

    public List<CommentVO> getCommentByGoodId(int goodId) {

        List<Comment> comments=commentDao.fetchAll(goodId);
        List<CommentVO> result=new ArrayList<CommentVO>();
        for (Comment c :comments) {
            CommentVO commentVO=new CommentVO();
            commentVO.update(c);
            result.add(commentVO);
        }
        return result;
    }

    public List<BuyRecordVO> getByShopId(int goodId) {

        List<BuyRecord> buyRecords=purchaseDao.getByGoodId(goodId);
        List<BuyRecordVO> result=new ArrayList<BuyRecordVO>();
        for (BuyRecord b :buyRecords) {
            BuyRecordVO buyRecordVO=new BuyRecordVO();
            buyRecordVO.update(b);
            result.add(buyRecordVO);
        }
        return result;
    }
}
