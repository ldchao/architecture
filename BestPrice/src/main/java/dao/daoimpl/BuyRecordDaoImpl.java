package dao.daoimpl;

import Entity.BuyRecord;
import Entity.Product;
import dao.BuyRecordDao;
import dao.MainConnection;
import dao.ReadConnection;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by dlydd on 2017/4/13.
 */
public class BuyRecordDaoImpl implements BuyRecordDao {

    public void save(BuyRecord buyRecord) {
        Session session= MainConnection.getSession();
        try {
            if (searchById(buyRecord.getId())==null){
                session.save(buyRecord);
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

    public void deleteById(int id) {
        Session session = MainConnection.getSession();
        try{
            BuyRecord buyRecord=searchById(id);
            session.delete(buyRecord);

            Transaction transaction=session.beginTransaction();
            transaction.commit();
            MainConnection.closeSession(session);

        }catch(Exception e){
            e.printStackTrace();
            MainConnection.closeSession(session);

        }
    }

    public BuyRecord searchById(int id) {
        Session session= ReadConnection.getSession();
        try {
            String hql="from BuyRecord as a where a.id="+id;
            Query query = session.createQuery(hql);
            List aList = query.list();
            ReadConnection.closeSession(session);
            if(aList.size()==0){
                return null;
            }else {
                BuyRecord buyRecord = (BuyRecord) aList.get(0);
                return buyRecord;
            }

        }catch (Exception e){
            e.printStackTrace();
            ReadConnection.closeSession(session);
            return  null;
        }
    }

    public List<BuyRecord> searchByProductid(int productid) {
        Session session= ReadConnection.getSession();
        try {
            String hql="from BuyRecord as a where a.productid="+productid;
            Query query = session.createQuery(hql);
            List aList = query.list();
            ReadConnection.closeSession(session);
            List<BuyRecord> buyRecords = (List<BuyRecord>) aList;
            return buyRecords;

        }catch (Exception e){
            e.printStackTrace();
            ReadConnection.closeSession(session);
            return  null;
        }
    }
}
