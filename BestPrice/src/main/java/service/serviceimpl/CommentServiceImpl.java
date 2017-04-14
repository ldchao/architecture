package service.serviceimpl;

import Entity.Comment;
import dao.CommentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.CommentService;
import service.commentmanage.check.SensitiveCheck;
import service.commentmanage.filter.CommentCheck;
import service.commentmanage.filter.CommentStorage;
import service.commentmanage.filter.SellerAttention;
import vo.CommentVO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hanifor on 4/10/2017.
 */
@Service
public class CommentServiceImpl implements CommentService{
    @Autowired
    private CommentDao commentDao;

    private CommentCheck commentCheck;
    private service.commentmanage.check.CommentCheck sensitiveCheck;
    /**
     * 可以动态添加新的filter处理comment
     */
    public CommentServiceImpl(){
        sensitiveCheck = new SensitiveCheck();
        CommentCheck source = new CommentStorage();
        commentCheck = new SellerAttention(source);
    }

    public boolean storeComment(CommentVO comment) {
        if(sensitiveCheck.checkComment(comment.getContent(), comment.getUserid(), comment.getProductid())){
            commentCheck.storeComment(comment.makeComment());
            return true;
        }
        return false;
    }

    public List<CommentVO> getComments(int productid) {
        List<Comment> cs = commentDao.fetchAll(productid);
        List<CommentVO> cvs = new ArrayList<CommentVO>();
        for (Comment c: cs) {
            CommentVO cv = new CommentVO();
            cv.update(c);
            cvs.add(cv);
        }
        return cvs;
    }
}
