package service.serviceimpl;

import Entity.Comment;
import service.CommentService;
import service.commentmanage.filter.CommentCheck;
import service.commentmanage.filter.CommentStorage;

/**
 * Created by Hanifor on 4/10/2017.
 */
public class CommentServiceImpl implements CommentService{
    private CommentCheck commentCheck;

    public CommentServiceImpl(){
        commentCheck = new CommentStorage();
    }

    public void storeComment(Comment comment) {
        commentCheck.storeComment(comment);
    }
}
