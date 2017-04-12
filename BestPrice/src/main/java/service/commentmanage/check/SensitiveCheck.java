package service.commentmanage.check;

import dao.SensitiveWordDao;
import org.springframework.beans.factory.annotation.Autowired;
import service.commentmanage.iterator.MyIterator;
import service.commentmanage.iterator.SensitiveIterator;
import service.commentmanage.observer.MyObserver;
import service.commentmanage.observer.MyObserverImpl;

/**
 * Created by L.H.S on 2017/4/9.
 *
 * 检测评论中的敏感词汇
 */
public class SensitiveCheck extends CommentCheck{

    @Autowired
    private SensitiveWordDao wordDao;


    private static MyIterator senIterator;

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

        if (checkSensitiveWord(comment)) { //
            
        }


        /* 如果为检测到敏感词汇，不做任何操作
        return true;
        */

        return false;
    }

    // 若含有敏感词汇返回false，否则true
    private static boolean checkSensitiveWord(String comment) {

        boolean valid = true;

        while (!senIterator.isEnd()) {
            if (comment.contains(senIterator.next())) {
                valid = false;
                break;
            }
        }

        return  valid;
    }

}
