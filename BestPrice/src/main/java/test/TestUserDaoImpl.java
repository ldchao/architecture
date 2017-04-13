package test;

import Entity.User;
import dao.daoimpl.UserDaoImpl;

/**
 * Created by dlydd on 2017/4/13.
 */
public class TestUserDaoImpl {
    public static void main(String[] args){
            testSave();
    }

    public static void testSave() {
        User user = new User();
        user.setUserid(1);
        user.setName("dd");
        user.setPassword("123");
        user.setEmail("123456789@qq.com");
        user.setAddress("nanjing");
        user.setState(0);
        UserDaoImpl userDao = new UserDaoImpl();
        userDao.addAUser(user);
    }
}
