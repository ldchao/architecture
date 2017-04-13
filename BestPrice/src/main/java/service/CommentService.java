package service;

import vo.CommentVO;

/**
 * Created by Hanifor on 4/10/2017.
 */
public interface CommentService {
    /**
     * 存储评论并审核
     */
    public void storeComment(CommentVO comment);
}
