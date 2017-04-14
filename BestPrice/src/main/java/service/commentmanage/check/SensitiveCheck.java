package service.commentmanage.check;

import Entity.Comment;
import dao.CommentDao;
import dao.SensitiveCommentDao;
import dao.SensitiveWordDao;
import dao.WaterUserDao;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.commentmanage.iterator.MyIterator;
import service.commentmanage.iterator.SensitiveIterator;
import service.commentmanage.observer.MyObserver;
import service.commentmanage.observer.MyObserverImpl;

import java.util.ArrayList;

/**
 * Created by L.H.S on 2017/4/9.
 * <p>
 * 检测评论中的敏感词汇
 */
@Service
public class SensitiveCheck extends CommentCheck {

    @Autowired
    private SensitiveWordDao wordDao;

    @Autowired
    private SensitiveCommentDao senCommentDao;

    @Autowired
    private CommentDao commentDao;

    @Autowired
    private WaterUserDao waterDao;

    private MyIterator senIterator;

    public SensitiveCheck() {

        // 初始化敏感词汇迭代器
        senIterator = new SensitiveIterator(wordDao.getSentiveWord());
    }

    public boolean checkComment(String comment, int userId, int proId) {

        // 每次只需要注册一次
        MyObserver ob = new MyObserverImpl();
        this.register(ob);

        /* 如果是敏感评论，则存储到敏感评论表，返回自增id
        int senId = intsaveSenComment();
        ob.notifyAdminComment(senId);
        return false;
        并检测是否为水军
        */

        /* 如果未检测到敏感词汇，不做任何操作
        return true;
        */

        if (checkSensitiveWord(comment)) { // 未含有敏感词汇，直接返回
            return true;
        } else { // 含有敏感词汇，做处理

            Comment com = new Comment();
            com.setContent(comment);
            com.setUserid(userId);
            com.setProductid(proId);

            int senId = senCommentDao.saveSenComment(com);
            this.notifyAdminComment(senId);  // 通知管理员潜在敏感评论

            checkWater(userId);

            return false;
        }
    }

    // 若含有敏感词汇返回false，否则true
    private boolean checkSensitiveWord(String comment) {

        boolean valid = true;

        while (!senIterator.isEnd()) {
            if (comment.contains(senIterator.next())) {
                valid = false;
                break;
            }
        }

        return valid;
    }

    // 检测是否是水军
    private void checkWater(int userId) {

        ArrayList<Comment> commentList = (ArrayList<Comment>) commentDao.getHistoryComments(userId);
         /*
         * 若是水军用户则存储到带判定水军表，并通知管理员

         * 若不是水军用户则不做处理
         * */

        boolean isWaterUser = false;
        for (Comment com : commentList) {
            if (!checkSensitiveWord(com.getContent())) {  // 含有敏感词汇
                isWaterUser = true;
                break;
            }
        }

        if (isWaterUser) {

            waterDao.saveWater(userId);

            this.notifyAdminUser(userId); // 通知管理员潜在水军用户
        }
    }

}
