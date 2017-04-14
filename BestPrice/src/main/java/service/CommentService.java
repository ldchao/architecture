package service;

import vo.CommentVO;

import java.util.List;

/**
 * Created by Hanifor on 4/10/2017.
 */
public interface CommentService {
    /**
     * 存储评论并审核
     */
    public boolean storeComment(CommentVO comment);

    public List<CommentVO> getComments(int productid);
}
