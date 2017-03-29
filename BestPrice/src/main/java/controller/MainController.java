package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2017/3/29.
 */
@Controller
public class MainController {

    @RequestMapping("/")
    public String index(){
        return "index";
    }

}
