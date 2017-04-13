package service.serviceimpl;

import Entity.User;
import dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.UserService;
import vo.UserVO;

/**
 * Created by ldchao on 2017/4/13.
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserDao userDao;

    public UserVO login(String email, String password) {

        User user=userDao.getUserByEmail(email);
        UserVO result=null;
        if(user!=null&&user.getPassword().equals(password)){
             result=new UserVO();
             result.update(user);
        }
        return result;
    }

    public UserVO register(UserVO userVO) {

        User user=userVO.makeUser();
        int id=userDao.addAUser(user);
        if(id==-1){
            return null;
        }else{
            userVO.setUserid(id);
            return userVO;
        }
    }

}
