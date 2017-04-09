package service.commentmanage.check;

import service.commentmanage.observer.MyObserver;

import java.util.ArrayList;


/**
 * Created by howSure on 2017/4/9.
 */
public abstract class CommentCheck {

    protected ArrayList<MyObserver> observers = new ArrayList<MyObserver>();

    /**
     * 返回值：true->合法评论，未检测到敏感词汇，正常发布到平台并存储到评论表
     *        false->检测到敏感词汇，不需要存储到评论表，
     * */
    public abstract boolean checkComment(String comment, int userId);

    protected void register(MyObserver ob) {
        observers.add(ob);
    }

    protected void detach(MyObserver ob) {
        observers.remove(ob);
    }

    // 敏感评论
    protected void notifyAdminComment(int sensitiveId) {
        for (MyObserver ob:observers) {
            ob.notifyAdminComment(sensitiveId);
        }
    }

    // 水军用户
    protected void notifyAdminUser(int userId) {
        for (MyObserver ob: observers) {
            ob.notifyAdminUser(userId);
        }
    }
}
