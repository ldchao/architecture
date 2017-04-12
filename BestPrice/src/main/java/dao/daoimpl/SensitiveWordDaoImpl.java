package dao.daoimpl;

import dao.Connection;
import dao.daoservice.SensitiveWordService;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by L.H.S on 2017/4/12.
 */
public class SensitiveWordDaoImpl implements SensitiveWordService {

    public List<String> getSentiveWord() {

        Session session = Connection.getSession();

//        String hql = "select word from SensitiveWord";
        String hql = "";
        List<String> list = Connection.getSession().createQuery(hql).list();
        Connection.closeSession(session);
        return list;
    }
}
