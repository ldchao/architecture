package dao.daoservice;

import Entity.Comment;

import java.util.List;

/**
 * Created by L.H.S on 2017/4/9.
 */
public interface SensitiveCommentService {

    // 存储敏感评论，返回自增Id
    int saveSenComment(String comment, int userId, int proId);

    // 获取敏感评论
    List<Comment> getSenComment();

    // 删除敏感评论
    void deleteSenComment(int comId);

    // 不是敏感评论，移除
    void releaseSenComment(int comId);
}
