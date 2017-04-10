package service.commentmanage.filter;

import Entity.Comment;
import dao.CommentDao;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Hanifor on 4/10/2017.
 */
public class CommentStorage implements CommentCheck{
    @Autowired
    private CommentDao commentDao;

    public void storeComment(Comment comment) {
        if(comment != null){
            commentDao.save(comment);
        }
    }
}
