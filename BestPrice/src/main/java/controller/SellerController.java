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

    /**
     * 更新商家关注词汇
     * @param words
     * @param request
     * @return
     */
    @RequestMapping(value ="/seller/attention/update")
    @ResponseBody
    public String updateKeyWords(List<String> words, HttpServletRequest request) {
        Object o = request.getSession().getAttribute("user");
        sellerService.updateKeyWords(((UserVO)o).getUserid(), words);
        return "success";
    }

    /**
     * 获取所有商家关注信息词汇
     * @param request
     * @return
     */
    @RequestMapping(value ="/seller/attention/get")
    @ResponseBody
    public List<String> getKeyWords(HttpServletRequest request) {
        Object o = request.getSession().getAttribute("user");
        return sellerService.getKeyWords(((UserVO)o).getUserid());
    }

    /**
     * 获取包含商家关注信息的评论
     * @param request
     * @return
     */
    @RequestMapping(value ="/seller/notify/get")
    @ResponseBody
    public List<CommentVO> getKeyComments(HttpServletRequest request) {
        Object o = request.getSession().getAttribute("user");
        return sellerService.getNotification(((UserVO)o).getUserid());
    }
}
