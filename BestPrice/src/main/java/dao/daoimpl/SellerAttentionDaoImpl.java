package dao.daoimpl;

import Entity.Notify;
import Entity.SellerWordList;
import dao.MainConnection;
import dao.ReadConnection;
import dao.SellerAttentionDao;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

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
        String hql = "select s.word from SellerWordList s where s.sellerid=" + id;
        List<String> list = session.createQuery(hql).list();
        ReadConnection.closeSession(session);

        return list;
    }

    public void saveNotification(Notify notify) {

        Session session = MainConnection.getSession();
        session.save(notify);
        MainConnection.closeSession(session);
    }

    public List<Notify> getNotifications(int id) {

        Session session = ReadConnection.getSession();
        String hql = "from Notify where id=" + id;
        List<Notify> list = session.createQuery(hql).list();
        ReadConnection.closeSession(session);

        return list;
    }
}
