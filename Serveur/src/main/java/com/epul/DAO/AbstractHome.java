package main.java.com.epul.DAO;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;

import main.java.com.epul.util.HibernateUtil;

public class AbstractHome {

	protected Session session;
	
	protected static final Log log = LogFactory.getLog(FilmHome.class);
	
	public AbstractHome() {
		session = HibernateUtil.getSessionFactory().getCurrentSession();
	}
}
