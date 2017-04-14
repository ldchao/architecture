package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import service.SearchGoodService;
import task.DispatcherMonitor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Administrator on 2017/3/29.
 */
@Controller
public class MainController {

    private static String realPath;
    @Autowired
    SearchGoodService searchGoodService;

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
     * @return commentManage
     */
    @RequestMapping("/commentManage")
    public ModelAndView commentManage() {
        ModelAndView mv = new ModelAndView("managerJSP/commentManage");
        return mv;
    }

    /**
     * 用户管理页面
     * @return userManage
     */
    @RequestMapping("/userManage")
    public ModelAndView userManage() {
        ModelAndView mv = new ModelAndView("managerJSP/commentManage");
        return mv;
    }

    /**
     * 广告管理页面
     * @return adsManage
     */
    @RequestMapping("/adsManage")
    public ModelAndView adsManage() {
        ModelAndView mv = new ModelAndView("managerJSP/commentManage");
        return mv;
    }


    @RequestMapping("/searchView")
    public ModelAndView searchView(String key){
        ModelAndView modelAndView = new ModelAndView("searchJSP/search");
        return modelAndView;
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
