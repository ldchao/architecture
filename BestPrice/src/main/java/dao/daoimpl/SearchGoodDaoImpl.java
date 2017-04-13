package dao.daoimpl;

import dao.CommentDao;
import dao.PurchaseDao;
import dao.ReadConnection;
import dao.SearchGoodDao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import vo.GoodVO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/4/10.
 */
@Repository
public class SearchGoodDaoImpl implements SearchGoodDao{
    public List<GoodVO> searchGoods(String key) {
    	String likekey="%"+key+"%";
    	
    	
    	Session session=ReadConnection.getSession();
		
		Transaction transaction= session.beginTransaction();

		List<Object[]> objectlist=session.createSQLQuery("select  PType.id as typeid,description,PType.name as typename,p.id as pid,p.price as price,link,sellerid,s.name as sellername,isJoin,competePrice,platform from (select * from ProductType where name like ? or description like ?) as PType,Product as p,Seller s where p.typeid=PType.id and s.id=p.sellerid")
		.setParameter(0, likekey).setParameter(1, likekey).list();
		
		
		transaction.commit();
		session.close();
		
		if (objectlist.size()==0||objectlist==null) {
			return null;
		}

		
		PurchaseDao pDao=new PurchaseDaoImpl();
		
		CommentDao cDao=new CommentDaoImpl();
		
		List<GoodVO> goodVOs=new ArrayList<GoodVO>();
		
		  for(Object[] o:objectlist)
		  {
		   //o[i]
		   
		   GoodVO vo=new GoodVO();
		   vo.setId((Integer) o[3]);
		   vo.setPrice((Double) o[4]);
		   vo.setDescription((String) o[1]);
		   vo.setProduct_name((String) o[2]);
		   vo.setSeller_name((String) o[7]);
		   vo.setPlatform((String) o[10]);
		   vo.setIsJoin((Integer) o[8]);
		   vo.setCompetePrice((Double) o[9]);
		   
		   vo.setComments_volume(cDao.fetchAll((Integer) o[3]).size());
		   
		   vo.setSales_volume(pDao.getByGoodId((Integer) o[3]).size());
		   
		   goodVOs.add(vo);
		  }
    	
    	
    	
        return goodVOs;
    }

    public List<String> searchHomoWord(String key) {
    	Session session=ReadConnection.getSession();
		
		Transaction transaction= session.beginTransaction();
    	
		List<String> strlist=session.createSQLQuery("select word from HomoWord where groupid in(select groupid from HomoWord where word=?)").setParameter(0, key).list();
    	
		transaction.commit();
		session.close();
		
		if (strlist.size()==0||strlist==null) {
			return null;
		}
		
    	
        return strlist;
    }
}
