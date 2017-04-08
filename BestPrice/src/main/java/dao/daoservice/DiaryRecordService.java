package dao.daoservice;

import Entity.DiaryRecord;

import java.util.Date;

/**
 * Created by dlydd on 2017/4/8.
 */
public interface DiaryRecordService {

    public boolean add(DiaryRecord dr);

    public boolean delete(DiaryRecord dr);

    public boolean update(DiaryRecord dr);

    public boolean search(Date date);
}
