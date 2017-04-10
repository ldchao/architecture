package service;

import Entity.Comment;

/**
 * Created by Hanifor on 4/10/2017.
 */
public interface CommentService {
    /**
     * 存储评论并审核
     */
    public void storeComment(Comment comment);
}
