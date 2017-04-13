package service.commentmanage.filter;

import Entity.Comment;
import Entity.Notify;
import Entity.Seller;
import dao.SellerAttentionDao;
import org.springframework.beans.factory.annotation.Autowired;

import Entity.Product;

import java.util.List;

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
        String content = comment.getContent();
        content = content.toLowerCase();
        Seller seller = comment.getProductByProductid().getSellerBySellerid();
        List<String> words = sellerAttentionDao.getKeyWords(seller.getId());
        for (String word : words) {
            if(content.contains(word)){
                sellerAttentionDao.saveNotification(new Notify(seller, comment.getId()));
                break;
            }
        }
        commentCheck.storeComment(comment);
    }
}