package dao.daoimpl;

import Entity.DiaryRecord;

import java.util.Date;

/**
 * 数据库备份实现
 * Created by dlydd on 2017/4/8.
 */
public class BackupImpl {

    //数据库其他表的备份未写（因为表未确定）

    //一下是日志记录备份的怎删改查
    public boolean add(DiaryRecord dr){
        return true;
    }

    public boolean delete(DiaryRecord dr){
        return true;
    }

    public boolean update(DiaryRecord dr){
        return true;
    }

    public boolean search(Date date){
        return true;
    }
}
