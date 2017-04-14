package service.serviceimpl;

import org.springframework.stereotype.Service;
import service.CommentService;
import service.commentmanage.check.SensitiveCheck;
import service.commentmanage.filter.CommentCheck;
import service.commentmanage.filter.CommentStorage;
import service.commentmanage.filter.SellerAttention;
import vo.CommentVO;

/**
 * Created by Hanifor on 4/10/2017.
 */
@Service
public class CommentServiceImpl implements CommentService{
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
}
