package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import service.SearchGoodService;

/**
 * Created by Administrator on 2017/3/29.
 */
@Controller
public class MainController {

    @Autowired
    SearchGoodService searchGoodService;

    @RequestMapping("/")
    public String index(){
        searchGoodService.searchGoods("hh");
        return "index";
    }

}
