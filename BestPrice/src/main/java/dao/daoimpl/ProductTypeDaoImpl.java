package dao.daoimpl;

import org.hibernate.Session;
import org.hibernate.Transaction;

import Entity.ProductType;

import dao.MainConnection;
import dao.ProductTypeDao;
import dao.ReadConnection;

public class ProductTypeDaoImpl implements ProductTypeDao{

	@Override
	public void addProductType(ProductType ptye) {
		// TODO Auto-generated method stub
		
		Session session=MainConnection.getSession();
		
		Transaction transaction= session.beginTransaction();
		
		session.save(ptye);
		
		transaction.commit();
		session.close();
		
		
		
		
	}

	@Override
	public void modifyProductType(ProductType ptye) {
		Session session=MainConnection.getSession();
		
		Transaction transaction= session.beginTransaction();
		
		session.update(ptye);
		
		transaction.commit();
		session.close();
		
	}

	@Override
	public ProductType getProductTypeByID(int id) {
		Session session=ReadConnection.getSession();
		
		Transaction transaction= session.beginTransaction();
		ProductType pType=(ProductType) session.createQuery("from ProductType where id=?").setParameter(0, id).list().get(0);
		
		transaction.commit();
		session.close();
		
		return pType;
	}

	@Override
	public ProductType getProductTypeByName(String name) {
		Session session=ReadConnection.getSession();
		
		Transaction transaction= session.beginTransaction();
		ProductType pType=(ProductType) session.createQuery("from ProductType where name=?").setParameter(0, name).list().get(0);
		
		transaction.commit();
		session.close();
		
		return pType;
	}

}
