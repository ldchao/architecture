package dao.daoimpl;

import Entity.Product;
import dao.MainConnection;
import dao.ProductDao;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by dlydd on 2017/4/13.
 */
public class ProductDaoImpl implements ProductDao{

    public void save(Product product) {
        Session session= MainConnection.getSession();
        try {
            if (search(product.getId())==null){
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

    public void delete(int id) {

    }

    public Product search(int id) {
        return null;
    }
}
