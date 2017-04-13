package service;

import Entity.User;
import vo.UserVO;

/**
 * Created by ldchao on 2017/4/12.
 */
public interface UserService {

    /**
     * 用户登录
     * @param name  用户名
     * @param password  用户密码
     * @return 如果登录成功返回UserVO,否则返回null
     */
    public UserVO login(String name, String password);

    /**
     * 用户注册新账号
     * @param userVO 注册信息
     * @return 返回注册成功后的UserVO
     */
    public UserVO register(UserVO userVO);
}
