package dao;

import Entity.Comment;

import java.util.List;

/**
 * Created by Hanifor on 4/10/2017.
 */
public interface CommentDao {
    /**
     * 保存评论
     * @param comment
     */
    public void save(Comment comment);

    /**
     * 获取一条评论
     * @param id 评论id
     * @return 一条评论
     */
    public Comment fetch(int id);

    /**
     * 获取一件商品所有评论
     * @param id 商品id
     * @return
     */
    public List<Comment> fetchAll(int id);

    /**
     * 删除评论
     * @param id 评论id
     */
    public void delete(int id);

    /**
     * L.H.S
     * 获取用户历史评论
     * @param userId 用户Id
     */
    public List<Comment> getHistoryComments(int userId);
}
