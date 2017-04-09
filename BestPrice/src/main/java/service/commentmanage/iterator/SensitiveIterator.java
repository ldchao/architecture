package service.commentmanage.iterator;

import java.util.ArrayList;

/**
 * Created by L.H.S on 2017/4/9.
 */
public class SensitiveIterator implements MyIterator {

    // 敏感词汇list
    private ArrayList<String> sensitveList = new ArrayList();
    private int cursor = 0;

    // 初始化敏感词汇list
    public SensitiveIterator() {

    }

    public String first() {

        if (sensitveList != null) {
            return sensitveList.get(0);
        }
        return null;
    }

    public String next() {

        cursor++;
        if (cursor < sensitveList.size()) {
            return sensitveList.get(cursor);
        }
        return null;
    }

    public String current() {
        return sensitveList.get(cursor);
    }

    public boolean isEnd() {
        if (cursor < sensitveList.size()) {
            return false;
        } else {
            return true;
        }
    }
}
