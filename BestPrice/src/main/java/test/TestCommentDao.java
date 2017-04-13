package test;

import Entity.Comment;
import dao.daoimpl.CommentDaoImpl;

import java.sql.Timestamp;

/**
 * Created by dlydd on 2017/4/12.
 */
public class TestCommentDao {
    public static  void  main(String args[]){

        TestSave();
        //testFetch(1);
    }

    public static void  TestSave(){
        Comment comment = new Comment();
        comment.setContent("");
        comment.setId(1);
        comment.setProductid(1);
        comment.setUserid(1);
        comment.setReplyid(1);
        Timestamp time = new Timestamp(2017,4,12,21,54,0,0);
        comment.setTime(time);
        comment.setState(0);
        CommentDaoImpl commentDao = new CommentDaoImpl();
        commentDao.save(comment);
        System.out.println("success!!");
    }

    public static void testFetch(int id){
        CommentDaoImpl commentDao =new CommentDaoImpl();
        commentDao.fetch(id);
    }
}
