package service.commentmanage.filter;

import Entity.Comment;
import dao.SellerAttentionDao;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;

/**
 * Created by Hanifor on 4/10/2017.
 */
public class SellerAttention implements CommentCheck {
    private CommentCheck commentCheck;

    @Autowired
    SellerAttentionDao sellerAttentionDao;

    public SellerAttention(CommentCheck commentCheck){
        this.commentCheck = commentCheck;
    }

    public void storeComment(Comment comment) {
        Entity.Product product = comment.getProductByProductid();
        product.
        sellerAttentionDao.getKeyWords()
    }
}
