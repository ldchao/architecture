package dao.daoservice;

import Entity.DiaryRecord;

import java.util.Date;

/**
 * 数据库备份接口
 * Created by dlydd on 2017/4/8.
 */
public interface BackupService {

    //数据库其他表的备份未写（因为表未确定）

    //一下是日志记录备份的怎删改查
    public boolean add(DiaryRecord dr);

    public boolean delete(DiaryRecord dr);

    public boolean update(DiaryRecord dr);

    public boolean search(Date date);
}
