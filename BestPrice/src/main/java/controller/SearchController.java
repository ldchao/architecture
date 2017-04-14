package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import service.SearchGoodService;
import vo.GoodVO;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lois on 2017/4/14.
 */

@RequestMapping(value = "/goods")
public class SearchController {

    private String success = "success";

    @Autowired
    SearchGoodService searchGoodService;


    /**
     *
     * @param key
     * @return
     */
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getGoods(String key){

        Map<String, Object> map = new HashMap<>();

        List<GoodVO> goodVOList = searchGoodService.searchGoods(key);

        map.put("list",goodVOList);

        return map;
    }





    public String sortResult(String sortRule, HttpServletRequest request){




        return null;
    }





}
