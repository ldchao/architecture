package controller;

<<<<<<< HEAD
import org.springframework.stereotype.Controller;
=======
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.CommentService;
import vo.CommentVO;

import javax.servlet.http.HttpServletRequest;
>>>>>>> origin/master

/**
 * Created by Xuanlin on 2017/4/12.
 */
<<<<<<< HEAD
@Controller
=======



@RequestMapping(value = "/comment")
>>>>>>> origin/master
public class CommentsController {
    @Autowired
    CommentService commentService;

    private String success = "success";
    private String input = "input";


    @RequestMapping(value = "/makeComment")
    @ResponseBody
    public String makeComment(String content,HttpServletRequest request) {
        CommentVO commentVO =new CommentVO();
        commentVO.setContent(content);
//unfinished
        return "success";
    }


}
