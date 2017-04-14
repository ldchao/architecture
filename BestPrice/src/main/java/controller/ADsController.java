package controller;

import Entity.ADs;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2017/4/12.
 */
@Controller
public class ADsController {

    @RequestMapping("/getAds")
    @ResponseBody
    public ADs toAds(){
        // TODO: 2017/4/14 返回最新广告
        return null;
    }

}
