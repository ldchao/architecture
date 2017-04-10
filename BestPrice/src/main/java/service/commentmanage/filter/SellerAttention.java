package service.commentmanage.filter;

import Entity.Comment;
import Entity.Notify;
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
        int sellerid = comment.getProductByProductid().getSellerBySellerid().getId();
        List<String> words = sellerAttentionDao.getKeyWords(sellerid);
        for (String word : words) {
            if(content.contains(word)){
                Notify notify = new Notify();
                sellerAttentionDao.saveNotification(notify);
                break;
            }
        }
        commentCheck.storeComment(comment);
    }
}
