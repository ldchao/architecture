package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.UserService;
import vo.UserVO;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2017/4/12.
 */
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/login")
    @ResponseBody
    public String login(String username, String password, HttpServletRequest request) {
        UserVO userVO = userService.login(username, password);
        if (userVO == null) {
            return "fail";
        } else {
            request.getSession().setAttribute("user", userVO);
            return "success";
        }
    }

    @RequestMapping(value = "/logup")
    @ResponseBody
    public String logup(String username, String password, String email, String address, HttpServletRequest request) {
        UserVO userVO = new UserVO();
        userVO.setName(username);
        userVO.setPassword(password);
        userVO.setEmail(email);
        userVO.setAddress(address);
        UserVO result  = userService.register(userVO);
        if (result == null) {
            return "fail";
        } else {
            return "success";
        }
    }


    @RequestMapping(value = "/logout")
    @ResponseBody
    public String logout(HttpServletRequest request) {
        request.getSession().removeAttribute("user");
        return "success";
    }
}
