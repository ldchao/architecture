package dao.daoimpl;

import Entity.Seller;
import Entity.User;
import dao.MainConnection;
import dao.ReadConnection;
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
    	Session session=MainConnection.getSession();
		
		Transaction transaction= session.beginTransaction();
		Seller seller=(Seller) session.createQuery("from Seller where id=?").setParameter(0, id).list().get(0);
		
		session.delete(seller);

		
		transaction.commit();
		session.close();
    }

    public Seller searchById(int id) {
    	Session session=ReadConnection.getSession();
		
		Transaction transaction= session.beginTransaction();
		Seller seller=(Seller) session.createQuery("from Seller where id=?").setParameter(0, id).list().get(0);
		
		transaction.commit();
		session.close();
		
		return seller;
    }
}
