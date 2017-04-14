package controller;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.CommentService;
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

    private String success = "success";
    private String input = "input";

    /**
     * 发布评论
     * @param commentVO
     * @param request
     * @return
     */
    @RequestMapping(value = "/comment/publish")
    @ResponseBody
    public String makeComment(CommentVO commentVO,HttpServletRequest request) {
        commentService.storeComment(commentVO);
        return success;
    }
}
