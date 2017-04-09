package dao.daoservice;

import Entity.SensitiveComment;

import java.util.List;

/**
 * Created by L.H.S on 2017/4/9.
 */
public interface SensitiveCommentService {

    // 存储敏感评论，返回自增Id
    int saveSenComment(String comment, int userId);

    // 获取敏感评论
    List<SensitiveComment> getSenComment();

    // 删除敏感评论
    void deleteSenComment(int senId);

    // 不是敏感评论，移除
    void releaseSenComment(int senId);
}
