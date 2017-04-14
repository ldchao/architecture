package dao.daoimpl;

import Entity.Seller;
import Entity.User;
import dao.MainConnection;
import dao.ReadConnection;
import dao.SellerDao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by dlydd on 2017/4/13.
 */
public class SellerDaoImpl implements SellerDao {
    public int save(Seller seller) {
        Session session= MainConnection.getSession();
        Integer id=new Integer(-1);
        
        try {
            if (searchById(seller.getId())==null){
                System.out.println("in!");
               id= (Integer) session.save(seller);
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
        return id;
        
    }

    public boolean deleteById(int id) {
    	Session session=MainConnection.getSession();
		
		Transaction transaction= session.beginTransaction();
		
		
		List<Seller> list=session.createQuery("from Seller where id=?").setParameter(0, id).list();
		
		if (list.size()==0||list==null) {
			transaction.commit();
			session.close();
			return false;
		}
		
		Seller seller=list.get(0);
		
		if (seller==null) {
			transaction.commit();
			session.close();
			return false;
		}
		
		session.delete(seller);

		
		transaction.commit();
		session.close();
		return true;
    }

    public Seller searchById(int id) {
    	Session session=ReadConnection.getSession();
		
		Transaction transaction= session.beginTransaction();
		List<Seller> list=session.createQuery("from Seller where id=?").setParameter(0, id).list();
		
		
		transaction.commit();
		session.close();
		
		if (list.size()==0||list==null) {
			return null;
		}
		
		Seller seller=list.get(0);
		
		
		return seller;
    }

	@Override
	public Seller searchByName(String name) {
		Session session=ReadConnection.getSession();
		Transaction transaction= session.beginTransaction();
		List<Seller> list=session.createQuery("from Seller where name=?").setParameter(0, name).list();
		
		
		transaction.commit();
		session.close();
		
		if (list.size()==0||list==null) {
			return null;
		}
		
		Seller seller=list.get(0);
		
		
		return seller;
		
	}

	@Override
	public List<Seller> getAllSellers() {
		Session session=ReadConnection.getSession();
		Transaction transaction= session.beginTransaction();
		
		List<Seller> list=session.createQuery("from Seller").list();
		
		transaction.commit();
		session.close();
		
		
		if(list.size()==0||list==null){
			return null;
		}else{
			return list;
		}
		
	
	}

	@Override
	public List<Seller> getAllSellersByPlatform(String platform) {
		Session session=ReadConnection.getSession();
		Transaction transaction= session.beginTransaction();
		
		List<Seller> list=session.createQuery("from Seller where platform=?").setParameter(0, platform).list();
		
		transaction.commit();
		session.close();
		
		
		if(list.size()==0||list==null){
			return null;
		}else{
			return list;
		}

	}
}
