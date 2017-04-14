package dao.daoimpl;

import dao.ReadConnection;
import dao.SensitiveWordDao;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

/**
 * Created by L.H.S on 2017/4/12.
 */

@Repository
public class SensitiveWordDaoImpl implements SensitiveWordDao {

    public ArrayList<String> getSentiveWord() {

        Session session = ReadConnection.getSession();
        String hql = "from SensitiveWord";
        ArrayList<String> list = (ArrayList<String>) session.createQuery(hql).list();
        ReadConnection.closeSession(session);
        return list;
    }
}
