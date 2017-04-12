package dao;

import Entity.Comment;

import java.util.List;

/**
 * Created by L.H.S on 2017/4/9.
 */
public interface SensitiveCommentDao {

    // 存储敏感评论，返回自增Id
    int saveSenComment(Comment comment);

    // 获取敏感评论
    List<Comment> getSenComment();

    // 删除敏感评论
    void deleteSenComment(int comId);

    // 不是敏感评论，移除，并发布
    void releaseSenComment(int comId);

}
