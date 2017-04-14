package dao.daoimpl;

import dao.MainConnection;
import dao.ReadConnection;
import dao.WaterUserDao;
import Entity.User;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by L.H.S on 2017/4/9.
 */

@Repository
public class WaterUserDaoImpl implements WaterUserDao {

    public void saveWater(int userId) {

        Session session = MainConnection.getSession();
        User user = session.find(User.class, userId);
        user.setState(0);
        MainConnection.closeSession(session);
    }

    public void freezeWaterUser(int userId) {
        Session session = MainConnection.getSession();
        User user = session.find(User.class, userId);
        user.setState(-1);
        session.update(user);
        MainConnection.closeSession(session);
    }

    public void releaseWaterUser(int userId) {
        Session session = MainConnection.getSession();
        User user = session.find(User.class, userId);
        user.setState(1);
        MainConnection.closeSession(session);
    }

    public ArrayList<User> getWater() {

        Session session = ReadConnection.getSession();
        String hql = "from User";
        List<User> userList = session.createQuery(hql).list();
        return (ArrayList<User>) userList;
    }
}
