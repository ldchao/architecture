package dao.daoimpl;

import org.hibernate.Session;
import org.hibernate.Transaction;

import Entity.User;
import dao.MainConnection;
import dao.ReadConnection;
import dao.UserDao;

public class UserDaoImpl implements UserDao{

	@Override //user main
	public int addAUser(User user) {
		Session session=MainConnection.getSession();
		
		Transaction transaction= session.beginTransaction();
		
		Integer id=	(Integer) session.save(user);
		
		transaction.commit();
		session.close();
		
		if(id==null){
			return -1;
		}else {
			return id;
		}
	}

	@Override  //user main
	public void modifyUser(User user) {
		Session session=MainConnection.getSession();
		
		Transaction transaction= session.beginTransaction();
		
		session.update(user);
		
		transaction.commit();
		session.close();
		
	}

	@Override  //user main
	public void deleteUser(int userid) {
		Session session=MainConnection.getSession();
		
		Transaction transaction= session.beginTransaction();
		User user=(User) session.createQuery("from User where userid=?").setParameter(0, userid).list().get(0);
		
		session.delete(user);

		
		transaction.commit();
		session.close();
		
	}

	@Override  //user read
	public User getUserByEmail(String email) {
		Session session=ReadConnection.getSession();
		
		Transaction transaction= session.beginTransaction();
		User user=(User) session.createQuery("from User where email=?").setParameter(0, email).list().get(0);
		
		transaction.commit();
		session.close();
		
		return user;
	}

	@Override
	public User getUserByID(int id) {
		Session session=ReadConnection.getSession();
		
		Transaction transaction= session.beginTransaction();
		User user=(User) session.createQuery("from User where userid=?").setParameter(0, id).list().get(0);
		
		transaction.commit();
		session.close();
		
		return user;
	}

}
