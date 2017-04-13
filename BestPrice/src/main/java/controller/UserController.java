package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.UserService;
import vo.UserVO;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2017/4/12.
 */
@RequestMapping(value = "/user")
@Controller
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
            if(userVO.getState()==1){
                return "user";  //普通用户
            }else if(userVO.getState()==-1){
                return "wateruser";  //水军
            }else if(userVO.getState()==0){
                return "un";  //用户审核中
            }else if(userVO.getState()==2){
                return "fail";  //商家
            }else if(userVO.getState()==3){
                return "fail";  //管理员
            }else{
                return "fail";  //非法用户
            }
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
