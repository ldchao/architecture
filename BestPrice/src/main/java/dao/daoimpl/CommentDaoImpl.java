package dao.daoimpl;

import Entity.Comment;
import dao.CommentDao;
import dao.MainConnection;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by Hanifor on 4/10/2017.
 */
public class CommentDaoImpl implements CommentDao {

    public void save(Comment comment) {
        Session session= MainConnection.getSession();
        try {
            if (fetch(comment.getId())==null){
               // System.out.println("in!");
                session.save(comment);
                Transaction transaction=session.beginTransaction();
                transaction.commit();
                MainConnection.closeSession(session);

            }else {
                MainConnection.closeSession(session);

            }
        }catch (Exception e){
            e.printStackTrace();
            MainConnection.closeSession(session);

        }
    }

    public Comment fetch(int id) {
        //TODO
        return null;
    }

    public List<Comment> fetchAll(int id) {
        //TODO
        return null;
    }

    public void delete(int id) {
        //TODO
    }
}
