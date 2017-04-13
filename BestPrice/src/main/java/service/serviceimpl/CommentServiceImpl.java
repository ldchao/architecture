package service.serviceimpl;

import Entity.Comment;
import org.springframework.stereotype.Service;
import service.CommentService;
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

    /**
     * 可以动态添加新的filter处理comment
     */
    public CommentServiceImpl(){
        CommentCheck source = new CommentStorage();
        commentCheck = new SellerAttention(source);
    }

    public void storeComment(CommentVO comment) {
        commentCheck.storeComment(comment.makeComment());
    }
}
