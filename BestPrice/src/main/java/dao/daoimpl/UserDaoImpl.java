package dao.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import Entity.User;

import dao.MainConnection;
import dao.ReadConnection;
import dao.UserDao;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao{

	//user main
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

	//user main
	public void modifyUser(User user) {
		Session session=MainConnection.getSession();
		
		Transaction transaction= session.beginTransaction();
		
		session.update(user);
		
		transaction.commit();
		session.close();
		
	}

	 //user main
	public boolean deleteUser(int userid) {
		Session session=MainConnection.getSession();
		
		Transaction transaction= session.beginTransaction();
		
		
		List<User> list=(List) session.createQuery("from User where userid=?").setParameter(0, userid).list();
		if (list.size()==0||list==null) {
			transaction.commit();
			session.close();
			return false;
		}
		
		User user=list.get(0);
		
		if (user==null) {
			transaction.commit();
			session.close();
			return false;
		}
		
		session.delete(user);

		
		transaction.commit();
		session.close();
		
		return true;
		
	}

	//user read
	public User getUserByEmail(String email) {
		Session session=ReadConnection.getSession();
		
		Transaction transaction= session.beginTransaction();
		List<User> list=(List) session.createQuery("from User where email=?").setParameter(0, email).list();
		
		
		
		transaction.commit();
		session.close();
		
		if (list.size()==0||list==null) {
			return null;
		}
		
		User user=list.get(0);
		
		return user;
	}
	
	public User getUserByID(int id) {
		Session session=ReadConnection.getSession();
		
		Transaction transaction= session.beginTransaction();
		List<User> list=(List) session.createQuery("from User where userid=?").setParameter(0, id).list();
		
		transaction.commit();
		session.close();
		
		if (list.size()==0||list==null) {
			return null;
		}
		
		User user=list.get(0);
		
		
		
		return user;
	}

}
