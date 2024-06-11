package server.dao;



import common.model.User;
import common.utils.HibernateAPI;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class UserDAO {

	 //---------------GET-USER-BY-USERNAME---------------------//
	
    public User getUserByUsername(String username) {
        try {
            SessionFactory sessionFactory = HibernateAPI.getSessionFactory();
            if (sessionFactory != null) {
                Session session = sessionFactory.openSession();
                try {
                    return session.createQuery("from User where username = :username", User.class)
                            .setParameter("username", username)
                            .uniqueResult();
                } finally {
                    session.close();
                }
            }
        	} catch (HibernateException e) {
        		e.printStackTrace();
        }
        return null;
    }

    
    //---------------ADD-USER---------------------//
    
    public void addUser(User user) {
        try {
            SessionFactory sessionFactory = HibernateAPI.getSessionFactory();
            if (sessionFactory != null) {
                Session session = sessionFactory.openSession();
                try {
                    Transaction tx = session.beginTransaction();
                    session.save(user);
                    tx.commit();
                } finally {
                    session.close();
                }
            }
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }
    
    
    //---------------IS-ACCOUNT-EXISTS---------------------//
    
    public boolean isAccountExists(String username) {
        Transaction transaction = null;
        boolean exists = false;
        try {
            SessionFactory sessionFactory = HibernateAPI.getSessionFactory();
            if (sessionFactory != null) {
                Session session = sessionFactory.openSession();
                try {
                    transaction = session.beginTransaction();
                    Query<User> query = session.createQuery("FROM AccountModel WHERE username = :username", User.class);
                    query.setParameter("username", username);
                    exists = query.uniqueResult() != null;
                    transaction.commit();
                } catch (Exception e) {
                    if (transaction != null) {
                        transaction.rollback();
                    }
                    e.printStackTrace();
                } finally {
                    session.close();
                }
            }
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return exists;
    }
}
