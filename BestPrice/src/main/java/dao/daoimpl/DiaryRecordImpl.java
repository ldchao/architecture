package dao.daoimpl;

import Entity.DiaryRecord;
import dao.daoservice.DiaryRecordService;

import java.util.Date;

/**
 * 日志记录实现
 * Created by dlydd on 2017/4/8.
 */
public class DiaryRecordImpl implements DiaryRecordService{
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
