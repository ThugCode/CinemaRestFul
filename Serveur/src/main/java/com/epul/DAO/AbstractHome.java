package main.java.com.epul.DAO;

import org.hibernate.Session;

import main.java.com.epul.util.HibernateUtil;

public class AbstractHome {

	protected Session session;
	
	public AbstractHome() {
		session = HibernateUtil.getSessionFactory().getCurrentSession();
	}
}
