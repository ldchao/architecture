package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by LeeKane on 17/4/9.
 */
@Controller
public class TestController {

    @RequestMapping("/test")
    @ResponseBody
    public String index(){
        return "hh";
    }

}
