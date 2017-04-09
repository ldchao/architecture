package service.commentmanage.check;

import service.commentmanage.iterator.MyIterator;

import java.util.ArrayList;

/**
 * Created by L.H.S on 2017/4/9.
 */
public class WaterCheck {

    private MyIterator senIterator;

    public WaterCheck() {

        // 初始化敏感词汇迭代器
    }

    public void checkUserHistory(int userId) {

        /*
        * 若是水军用户则存储到带判定水军表，并通知管理员


        * 若不是水军用户则不做处理
        * */

    }

    private ArrayList<String> getHistoryComment(int userId) {

        return null;
    }

}
