package common.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateAPI {
	private static final SessionFactory sesssionFactory =  buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		
		try {
			return new Configuration().configure().buildSessionFactory();
		} catch (Exception e) {
			System.out.println("Lỗi không thể tạo SessionFactory");
			e.printStackTrace();
			return null;
		}
	}
	
	public static SessionFactory getSessionFactory() {
		return sesssionFactory;
	}
	
	public static void shutdown() {
		getSessionFactory().close();
	}
}