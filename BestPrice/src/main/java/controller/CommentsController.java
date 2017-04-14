package controller;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.CommentService;
import service.admincheck.AdminCheck;
import vo.CommentVO;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Xuanlin on 2017/4/12.
 */
@Controller
@RequestMapping(value = "/comment")
public class CommentsController {
    @Autowired
    CommentService commentService;
    @Autowired
    AdminCheck adminCheck;

    private String success = "success";
    private String input = "input";

    /**
     * 发布评论
     * @param commentVO
     * @param request
     * @return success if succeed, input if the comment contains sensitive words and fails to be published.
     */
    @RequestMapping(value = "/comment/publish")
    @ResponseBody
    public String makeComment(CommentVO commentVO,HttpServletRequest request) {
        if(commentService.storeComment(commentVO)){
            return success;
        }else{
            return input;
        }
    }


    /**
     * 删除敏感评论
     * */
    @RequestMapping(value = "/deleteSen")
    @ResponseBody
    public String deleteSen(int comId) {

        adminCheck.deleteSenComment(comId);
        return "success";
    }
}
