package dao.daoimpl;

import Entity.Ip;
import dao.ShieldIPDao;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lois on 2017/4/9.
 */
@Repository
public class ShieldIPDaoImpl implements ShieldIPDao {

    //TODO
    //向数据库读写，具体内容未实现

    public boolean add(Ip ip) {
        return false;
    }

    public boolean delete(Ip ip) {
        return false;
    }

    public boolean update(Ip ip) {
        return false;
    }

    public List<Ip> query() {
        return new ArrayList<Ip>();
    }
}