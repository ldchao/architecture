package dao.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import Entity.ProductType;

import dao.MainConnection;
import dao.ProductTypeDao;
import dao.ReadConnection;


@Repository
public class ProductTypeDaoImpl implements ProductTypeDao{

	@Override
	public int addProductType(ProductType ptye) {
		// TODO Auto-generated method stub
		
		Session session=MainConnection.getSession();
		
		Transaction transaction= session.beginTransaction();
		
		Integer id=(Integer) session.save(ptye);
		
		transaction.commit();
		session.close();
		if (id==null) {
			return -1;
		}
		return id;
		
		
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
		
		
		List<ProductType> list=session.createQuery("from ProductType where id=?").setParameter(0, id).list();
		
		transaction.commit();
		session.close();
		
		if (list.size()==0||list==null) {
			return null;
		}
		
		ProductType pType=list.get(0);
		
		
		
		return pType;
	}

	@Override
	public ProductType getProductTypeByName(String name) {
		Session session=ReadConnection.getSession();
		
		Transaction transaction= session.beginTransaction();
		List<ProductType> list=session.createQuery("from ProductType where name=?").setParameter(0, name).list();
		
		transaction.commit();
		session.close();
		
		if (list.size()==0||list==null) {
			return null;
		}
		
		ProductType pType=list.get(0);
		
		
		return pType;
	}

	@Override
	public ArrayList<String> getAllProductName() {
		Session session=ReadConnection.getSession();
		
		Transaction transaction= session.beginTransaction();
		
		List<ProductType> list=session.createQuery("from ProductType").list();
		
		
		transaction.commit();
		session.close();
		if (list.size()==0||list==null) {
			return null;
		}
		
		ArrayList<String> strlist=new ArrayList<String>();
		
		for (ProductType productType : list) {
			String name=productType.getName();
			strlist.add(name);
		}
		
		return strlist;
	}

}
