package dao.daoimpl;

import Entity.Comment;
import dao.MainConnection;
import dao.ReadConnection;
import dao.SensitiveCommentDao;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by L.H.S on 2017/4/9.
 */

@Repository
public class SensitiveCommentDaoImpl implements SensitiveCommentDao {

    public int saveSenComment(Comment comment) {

        Session session = MainConnection.getSession();
        session.save(comment);
        int senId = comment.getId();
        MainConnection.closeSession(session);

        return senId;
    }

    public List<Comment> getSenComment() {

        Session session = ReadConnection.getSession();
        String hql = "from Comment c where c.state=0";
        List<Comment> comments = session.createQuery(hql).list();
        ReadConnection.closeSession(session);

        return comments;
    }

    public void deleteSenComment(int comId) {

        Session session = MainConnection.getSession();
        Comment comment = session.load(Comment.class, comId);
        comment.setState(-1);
        session.update(comment);
        MainConnection.closeSession(session);

    }

    public void releaseSenComment(int comId) {

        Session session = MainConnection.getSession();
        Comment comment = session.get(Comment.class, comId);
        comment.setState(1);
        session.update(comment);
        MainConnection.closeSession(session);
    }
}
