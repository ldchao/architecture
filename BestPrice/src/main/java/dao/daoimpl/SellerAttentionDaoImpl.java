package dao.daoimpl;

import Entity.Comment;
import Entity.Notify;
import Entity.SellerWordList;
import dao.MainConnection;
import dao.ReadConnection;
import dao.SellerAttentionDao;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hanifor on 4/10/2017.
 */
@Repository
public class SellerAttentionDaoImpl implements SellerAttentionDao {

    public void updateKeyWords(int id, List<String> keys) {

        Session session = MainConnection.getSession();
        String hql = "from SellerWordList where sellerid=" + id;
        List<SellerWordList> oldList = session.createQuery(hql).list();
        for (SellerWordList swl: oldList) {
            session.delete(swl);
        }

        for (String word: keys) {
            SellerWordList sellerWord = new SellerWordList();
            sellerWord.setSellerid(id);
            sellerWord.setWord(word);

            session.save(sellerWord);
        }

        MainConnection.closeSession(session);
    }

    public List<String> getKeyWords(int id) {
        Session session = ReadConnection.getSession();
        String hql = "select s.word from sellerwordlist s where s.sellerid=" + id;
        List<String> list = session.createNativeQuery(hql).list();
        ReadConnection.closeSession(session);

        return list;
    }

    public void saveNotification(Notify notify) {

        Session session = MainConnection.getSession();
        session.save(notify);
        MainConnection.closeSession(session);
    }

    public List<Comment> getNotifications(int id) {
        Session session = ReadConnection.getSession();
        String hql = "from Notify where id=" + id;
        List<Notify> list = session.createQuery(hql).list();
        List<Comment> comments = new ArrayList<Comment>();
        for (Notify notify: list) {
            hql = "from Comment where id=" + notify.getCommentid();
            comments.add(session.createQuery(hql, Comment.class).getSingleResult());
        }
        ReadConnection.closeSession(session);
        return comments;
    }
}