package controller;

import Entity.ADs;
import Entity.Comment;
import Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import service.SearchGoodService;
import service.admincheck.AdminCheck;
import service.serviceimpl.adServiceImpl.AdManager;
import task.DispatcherMonitor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by Administrator on 2017/3/29.
 */
@Controller
public class MainController {

    private static String realPath;
    @Autowired
    private SearchGoodService searchGoodService;
    @Autowired
    private AdminCheck adminCheck;

    @RequestMapping("/")
    public String main() {
        String ip = DispatcherMonitor.getIP();
        System.out.println(ip);
        return "redirect:http://" + ip + ":8080/index";
    }

    /**
     * 首页
     * @return index
     */
    @RequestMapping("/index")
    public String index(HttpServletRequest httpServletRequest) {
        realPath=httpServletRequest.getSession().getServletContext().getRealPath("/");
        System.out.println(realPath);
        return "index";
    }


    /**
     * 评论管理页面
     * @by LHS
     * @return commentManage
     * 返回待审核的敏感评论
     */
    @RequestMapping("/commentManage")
    public ModelAndView commentManage() {
        ModelAndView mv = new ModelAndView("managerJSP/commentManage");
        ArrayList<Comment> comments = adminCheck.getSenComment();
        mv.addObject("senComments", comments);

        return mv;
    }

    /**
     * 用户管理页面
     * @by LHS
     * @return userManage
     * 返回待审核的水军
     */
    @RequestMapping("/userManage")
    public ModelAndView userManage() {
        ModelAndView mv = new ModelAndView("managerJSP/userManage");
        ArrayList<User> users = adminCheck.getWaterUser();
        mv.addObject("waterUser", users);

        return mv;
    }

    /**
     * 广告管理页面
     * @return adsManage
     */
    @RequestMapping("/adsManage")
    public ModelAndView adsManage() {
        AdManager adManager = new AdManager();
        ModelAndView mv = new ModelAndView("managerJSP/adsManage");
        ArrayList<ADs> ads = adManager.get();
        mv.addObject("ads", ads);
        return mv;
    }


    @RequestMapping("/searchView")
    public ModelAndView searchView(String key){
        ModelAndView modelAndView = new ModelAndView("searchJSP/search");
        return modelAndView;
    }

    @RequestMapping("/toSearch")
    public void toSearch(String key, HttpServletRequest request){
        request.getSession().setAttribute("key", key);
    }

    @RequestMapping("/getVolume")
    @ResponseBody
    public String getVisitorVolume() {
        return "10";
    }

    public static String getServletContextPath(){
        return realPath;
    }

}
