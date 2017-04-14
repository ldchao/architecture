package dao.daoimpl;

import Entity.Comment;
import dao.CommentDao;
import dao.MainConnection;
import dao.ReadConnection;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hanifor on 4/10/2017.
 */
@Repository
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
        Session session= ReadConnection.getSession();
        try {
            String hql="from Comment as a where a.id="+id;
            Query query = session.createQuery(hql);
            List aList = query.list();
            ReadConnection.closeSession(session);
            if(aList.size()==0){
                return null;
            }else {
                Comment comment = (Comment) aList.get(0);
                return comment;
            }

        }catch (Exception e){
            e.printStackTrace();
            ReadConnection.closeSession(session);
            return  null;
        }
    }

    public List<Comment> fetchAll(int id) {
        Session session= ReadConnection.getSession();
        try {
            String hql="from Comment as a where a.productid="+id;
            Query query = session.createQuery(hql);
            List aList = query.list();
            ReadConnection.closeSession(session);
            ArrayList<Comment> cList =(ArrayList<Comment>)aList;
            return cList;
        }catch (Exception e){
            e.printStackTrace();
            ReadConnection.closeSession(session);
            return  new ArrayList<Comment>();
        }
    }

    public void delete(int id) {
        Session session = MainConnection.getSession();
        try{
            Comment comment=fetch(id);
            session.delete(comment);

            Transaction transaction=session.beginTransaction();
            transaction.commit();
            MainConnection.closeSession(session);

        }catch(Exception e){
            e.printStackTrace();
            MainConnection.closeSession(session);

        }
    }

    public List<Comment> getHistoryComments(int userId) {

        Session session = ReadConnection.getSession();
        String hql = "from Comment where userid=" + userId;
        List<Comment> comments = session.createQuery(hql).list();
        ReadConnection.closeSession(session);

        return  comments;
    }
}
