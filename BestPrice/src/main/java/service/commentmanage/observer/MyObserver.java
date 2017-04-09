package service.commentmanage.observer;

/**
 * Created by howSure on 2017/4/9.
 */
public interface MyObserver {

    // 通知管理员敏感评论
    /**
     * comment: 评论内容
     */
    void notifyAdminComment(int sensitiveId);

    // 通知管理员水军用户
    void notifyAdminUser(int userId);
}
