package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.SellerService;
import vo.CommentVO;
import vo.UserVO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Administrator on 2017/4/12.
 */
@Controller
public class SellerController {
    @Autowired
    SellerService sellerService;

    @RequestMapping(value ="/seller/attention/update")
    @ResponseBody
    public String updateKeyWords(List<String> words, HttpServletRequest request) {
        Object o = request.getSession().getAttribute("user");
        sellerService.updateKeyWords(((UserVO)o).getUserid(), words);
        return "success";
    }

    @RequestMapping(value ="/seller/attention/get")
    @ResponseBody
    public List<String> getKeyWords(HttpServletRequest request) {
        Object o = request.getSession().getAttribute("user");
        return sellerService.getKeyWords(((UserVO)o).getUserid());
    }

    @RequestMapping(value ="/seller/notify/get")
    @ResponseBody
    public List<CommentVO> getKeyComments(HttpServletRequest request) {
        Object o = request.getSession().getAttribute("user");
        return sellerService.getNotification(((UserVO)o).getUserid());
    }
}
