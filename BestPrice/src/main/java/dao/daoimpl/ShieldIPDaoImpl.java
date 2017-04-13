package dao.daoimpl;

import Entity.Ip;
import dao.MainConnection;
import dao.ReadConnection;
import dao.ShieldIPDao;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lois on 2017/4/9.
 */
@Repository
public class ShieldIPDaoImpl implements ShieldIPDao {

    public boolean add(Ip ip) {

        Session session = MainConnection.getSession();
        session.save(ip);
        MainConnection.closeSession(session);

        return true;
    }

    public boolean delete(Ip ip) {

        Session session = MainConnection.getSession();
        session.delete(ip);
        MainConnection.closeSession(session);

        return true;
    }

    public boolean update(Ip ip) {

        Session session = MainConnection.getSession();
        session.update(ip);
        MainConnection.closeSession(session);

        return true;
    }

    public List<Ip> query() {

        Session session = ReadConnection.getSession();
        String hql = "from Ip";
        List<Ip> list = session.createQuery(hql).list();
        ReadConnection.closeSession(session);

        return list;
    }
}