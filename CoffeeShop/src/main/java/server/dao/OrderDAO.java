package server.dao;


import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import common.model.Order;

import common.utils.HibernateAPI;

public class OrderDAO {
	private SessionFactory sessionFactory;


	 //---------------ADD-ORDER---------------------//
	
	public void addOrder(Order order) {
	    try {
	        SessionFactory sessionFactory = HibernateAPI.getSessionFactory();
	        if (sessionFactory != null) {
	            Session session = sessionFactory.openSession();
	            try {
	                Transaction tx = session.beginTransaction();
	                session.save(order);
	                tx.commit();
	            } finally {
	                session.close();
	            }
	        }
	    } catch (HibernateException e) {
	        e.printStackTrace();
	    }
	}
    
	 //---------------GET-ORDER-BY-KEYWORD---------------------//
	
	public List<Order> getOrderByKeyword(String keyword) {
		List<Order> orders = null;
		try {
			SessionFactory sessionFactory = HibernateAPI.getSessionFactory();
			if (sessionFactory != null) {
				try {
					Session session = sessionFactory.openSession();
//				    Transaction tx = session.beginTransaction(); 
					String hql = "FROM Order p WHERE LOWER(p.Creator) LIKE :keyword ORDER BY date DESC";
					Query<Order> query = session.createQuery(hql, Order.class);
					query.setParameter("keyword", "%" + keyword.toLowerCase() + "%");
//				    tx.commit();
					orders = query.list();
				} catch (Exception e) {

					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return orders;
	}
	
	 //---------------GET-ALL-ORDERS---------------------//
    
    public  List<Order> getAllOrders() {
		List<Order> orders = null;
		try {
			SessionFactory sessionFactory = HibernateAPI.getSessionFactory();
			if (sessionFactory != null) {
				Session session = sessionFactory.openSession();
				try {
					// Transaction tx = session.beginTransaction();
					Query<Order> query = session.createQuery("FROM Order ORDER BY date DESC", Order.class);
					orders = query.list();
					// tx.commit();
				} finally {
					session.close();
				}
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return orders;
	}
    
    //---------------GET-BY-DATE-ORDER---------------------//
    
    public List<Order> getByDateOrder(int day, int month, int year) {
        List<Order> orders = null;
        try {
            SessionFactory sessionFactory = HibernateAPI.getSessionFactory();
            if (sessionFactory != null) {
                try {
                    Session session = sessionFactory.openSession();
                    String hql = "FROM Order p WHERE DAY(p.Date) = :day AND MONTH(p.Date) = :month AND YEAR(p.Date) = :year ORDER BY Date DESC";
                    Query<Order> query = session.createQuery(hql, Order.class);
                    query.setParameter("year", year);
                    query.setParameter("month", month);
                    query.setParameter("day", day);
                    orders = query.list();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orders;
    }
    
    
}

