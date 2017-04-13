package dao.daoimpl;

import Entity.Seller;
import dao.MainConnection;
import dao.SellerDao;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by dlydd on 2017/4/13.
 */
public class SellerDaoImpl implements SellerDao {
    public void save(Seller seller) {
        Session session= MainConnection.getSession();
        try {
            if (searchById(seller.getId())==null){
                System.out.println("in!");
                session.save(seller);
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

    }

    public Seller searchById(int id) {
        return null;
    }
}
