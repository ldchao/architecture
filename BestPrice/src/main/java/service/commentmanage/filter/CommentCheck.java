package service.commentmanage.filter;

import Entity.Comment;
import org.springframework.stereotype.Component;

/**
 * Created by Hanifor on 4/10/2017.
 */
public interface CommentCheck {
    public void storeComment(Comment comment);
}
