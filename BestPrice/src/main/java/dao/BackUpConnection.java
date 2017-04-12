package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



public class BackUpConnection {
    private static Configuration configuration;
    private static SessionFactory sessionFactory;
    
  

    private BackUpConnection(){

    }


    public static Session getSession(){
        if (sessionFactory==null){
            configuration=new Configuration().configure("hibernateBackUp.cfg.xml");
            sessionFactory=configuration.buildSessionFactory();
        
            
            return sessionFactory.openSession();
        }else {
            return sessionFactory.openSession();
        }
    }

    public static void closeSession(Session session){
        session.close();
    }
}
