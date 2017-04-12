package dao.daoimpl;


import dao.ReadConnection;
import dao.SensitiveWordDao;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by L.H.S on 2017/4/12.
 */
public class SensitiveWordDaoImpl implements SensitiveWordDao {

    public List<String> getSentiveWord() {

        Session session = ReadConnection.getSession();

//        String hql = "select word from SensitiveWord";
        String hql = "";
        List<String> list = ReadConnection.getSession().createQuery(hql).list();
        ReadConnection.closeSession(session);
        return list;
    }
}
