package dao.daoimpl;

import Entity.Product;
import dao.MainConnection;
import dao.ProductDao;
import dao.ReadConnection;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dlydd on 2017/4/13.
 */
public class ProductDaoImpl implements ProductDao{

    public void save(Product product) {
        Session session= MainConnection.getSession();
        try {
            if (searchById(product.getId())==null){
                session.save(product);
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
            Product product=searchById(id);
            session.delete(product);

            Transaction transaction=session.beginTransaction();
            transaction.commit();
            MainConnection.closeSession(session);

        }catch(Exception e){
            e.printStackTrace();
            MainConnection.closeSession(session);

        }
    }

    public Product searchById(int id) {
        Session session= ReadConnection.getSession();
        try {
            String hql="from Product as a where a.id="+id;
            Query query = session.createQuery(hql);
            List aList = query.list();
            ReadConnection.closeSession(session);
            if(aList.size()==0){
                return null;
            }else {
                Product product = (Product) aList.get(0);
                return product;
            }

        }catch (Exception e){
            e.printStackTrace();
            ReadConnection.closeSession(session);
            return  null;
        }
    }
}
