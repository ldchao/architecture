package vo;

import Entity.Comment;
import Entity.Product;
import Entity.User;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

/**
 * Created by Administrator on 2017/4/11.
 */
public class CommentVO {
    private int id;
    private String time;
    private String content;
    private Integer state;
    private int productid;
    private int userid;
    private int replyid;

    public CommentVO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getReplyid() {
        return replyid;
    }

    public void setReplyid(int replyid) {
        this.replyid = replyid;
    }

    public Comment makeComment(){
        Comment comment=new Comment();
        Product productByProductid=new Product();
        User userByUserid=new User();
        Comment commentByReplyid=new Comment();
        productByProductid.setId(productid);
        userByUserid.setUserid(userid);
        commentByReplyid.setId(replyid);
        comment.setId(id);
        comment.setTime(Timestamp.valueOf(time));
        comment.setState(state);
        comment.setContent(content);
        comment.setProductByProductid(productByProductid);
        comment.setUserByUserid(userByUserid);
        comment.setCommentByReplyid(commentByReplyid);
        return comment;
    }

    public void update(Comment comment){
        this.id=comment.getId();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.time=df.format(comment.getTime());
        this.state=comment.getState();
        this.content=comment.getContent();
        this.productid=comment.getProductByProductid().getId();
        this.userid=comment.getUserByUserid().getUserid();
        this.replyid=comment.getCommentByReplyid().getId();
    }
}
