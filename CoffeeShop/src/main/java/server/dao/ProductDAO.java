package server.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import common.model.Product;
import common.model.User;
import common.utils.HibernateAPI;

import java.util.List;



public class ProductDAO {
    private SessionFactory sessionFactory;


    //---------------ADD-PRODUCT---------------------//
    
    public void addProduct(Product product) {
    	try {
        	SessionFactory sessionFactory = HibernateAPI.getSessionFactory();
        	if(sessionFactory != null) {
        		Session session = sessionFactory.openSession();	
    			try {
        			Transaction tx = session.beginTransaction();        			
        			session.save(product);
        			tx.commit();
				} finally {
					session.close();					
				}
        	}
			
		} catch (HibernateException e) {
			e.printStackTrace();
		}
    }

    
    //---------------UPDATE-PRODUCT---------------------//
    
    public void updateProduct(Product product) {
    	
    	try {
        	SessionFactory sessionFactory = HibernateAPI.getSessionFactory();
        	if(sessionFactory != null) {
        		Session session = sessionFactory.openSession();	
    			try {
        			Transaction tx = session.beginTransaction();        			
        			session.saveOrUpdate(product);
        			tx.commit();
				} finally {
					session.close();					
				}
        	}
			
		} catch (HibernateException e) {
			e.printStackTrace();
		}
    }
    
    
    //---------------DELETE-PRODUCT---------------------//
    
    public void deleteProduct(Product product) {
        try {
        	SessionFactory sessionFactory = HibernateAPI.getSessionFactory();
        	if(sessionFactory != null) {
        		Session session = sessionFactory.openSession();	
    			try {
        			Transaction tx = session.beginTransaction();        			
        			session.delete(product);
        			tx.commit();
				} finally {
					session.close();					
				}
        	}
			
		} catch (HibernateException e) {
			e.printStackTrace();
		}
    }
    
    //---------------GET-PRODUCT-BY-ID---------------------//

    public Product getProductById(int productId) {
        Product product = null;
        try {
        	SessionFactory sessionFactory = HibernateAPI.getSessionFactory();
        	if(sessionFactory != null) {
        		Session session = sessionFactory.openSession();	
    			try {
        			Transaction tx = session.beginTransaction();        			
        			Query<Product> query = session.createQuery("FROM Product WHERE ID = :id", Product.class);
        			query.setParameter("id", productId);
        			product = query.uniqueResult();
        			tx.commit();
				} finally {
					session.close();					
				}
        	}
			
		} catch (HibernateException e) {
			e.printStackTrace();
		}
        return product;
    }
    
    
    //---------------GET-PRODUCTS-AVAILABLE---------------------//
    
    
    public boolean isProductNameExists(String productName) {
        Session session = HibernateAPI.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Query query = session.createQuery("SELECT COUNT(*) FROM Product WHERE productName = :name");
            query.setParameter("name", productName);
            long count = (long) query.uniqueResult();
            transaction.commit();
            return count > 0;
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return false;
    }
    
    
    
    //---------------GET-ALL-PRODUCTS---------------------//
    
	public List<Product> getAllProducts() {
		List<Product> products = null;
		try {
			SessionFactory sessionFactory = HibernateAPI.getSessionFactory();
			if (sessionFactory != null) {
				Session session = sessionFactory.openSession();
				try {
					// Transaction tx = session.beginTransaction();
					Query<Product> query = session.createQuery("FROM Product", Product.class);
					products = query.list();
					// tx.commit();
				} finally {
					session.close();
				}
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return products;
	}
    
	
	
	
	 //---------------GET-PRODUCTS-BY-KEYWORD---------------------//
	
	public List<Product> getProductsByKeyword(String keyword) {
		List<Product> products = null;
		try {
			SessionFactory sessionFactory = HibernateAPI.getSessionFactory();
			if (sessionFactory != null) {
				try {
					Session session = sessionFactory.openSession();
					String hql = "FROM Product p WHERE LOWER(p.productName) LIKE :keyword";
					Query<Product> query = session.createQuery(hql, Product.class);
					query.setParameter("keyword", "%" + keyword.toLowerCase() + "%");
					products = query.list();
				} catch (Exception e) {

					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return products;
	}
}
