package dao.daoimpl;

import Entity.ADs;
import Entity.BuyRecord;
import dao.AdDao;
import dao.MainConnection;
import dao.ReadConnection;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by dlydd on 2017/4/14.
 */
public class AdDaoImpl implements AdDao{

    public void save(ADs aDs) {
        Session session= MainConnection.getSession();
        try {

                session.save(aDs);
                Transaction transaction=session.beginTransaction();
                transaction.commit();
                MainConnection.closeSession(session);


        }catch (Exception e){
            e.printStackTrace();
            MainConnection.closeSession(session);
        }
    }

    public void delete(ADs aDs) {
        Session session = MainConnection.getSession();
        try{
            session.delete(aDs);

            Transaction transaction=session.beginTransaction();
            transaction.commit();
            MainConnection.closeSession(session);

        }catch(Exception e){
            e.printStackTrace();
            MainConnection.closeSession(session);

        }
    }

    public void update(ADs aDs) {
        Session session = MainConnection.getSession();
        try{
            session.update(aDs);

            Transaction transaction=session.beginTransaction();
            transaction.commit();
            MainConnection.closeSession(session);

        }catch(Exception e){
            e.printStackTrace();
            MainConnection.closeSession(session);

        }
    }

    public List<ADs> getAll() {
        Session session= ReadConnection.getSession();
        try {
            String hql="from ADs as a";
            Query query = session.createQuery(hql);
            List aList = query.list();
            ReadConnection.closeSession(session);


                return (List<ADs>)aList;


        }catch (Exception e){
            e.printStackTrace();
            ReadConnection.closeSession(session);
            return  null;
        }
    }
}
