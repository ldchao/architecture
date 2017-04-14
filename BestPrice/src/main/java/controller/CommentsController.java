package controller;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.CommentService;
import service.admincheck.AdminCheck;
import vo.CommentVO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Xuanlin on 2017/4/12.
 */
@Controller
@RequestMapping(value = "/comment")
public class CommentsController {
    @Autowired
    CommentService commentService;
    AdminCheck adminCheck;

    private String success = "success";
    private String input = "input";

    public CommentsController(){
        adminCheck = new AdminCheck();
    }

    /**
     * 发布评论
     * @param request
     * @return success if succeed, input if the comment contains sensitive words and fails to be published.
     */
    @RequestMapping(value = "/comment/publish")
    @ResponseBody
    public String makeComment(String content, int productid, int userid, int replyid, HttpServletRequest request) {
        CommentVO commentVO = new CommentVO(content, productid, userid, replyid);
        if(commentService.storeComment(commentVO)){
            return success;
        }else{
            return input;
        }
    }

    /**
     * 删除敏感评论
     * */
    @RequestMapping(value = "/comment/delete")
    @ResponseBody
    public String deleteSen(int comId) {
        adminCheck.deleteSenComment(comId);
        return "success";
    }

    @RequestMapping(value = "/comment/get")
    @ResponseBody
    public List<CommentVO> getComment(int productId){
        return commentService.getComments(productId);
    }
}
