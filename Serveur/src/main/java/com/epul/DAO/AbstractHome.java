package main.java.com.epul.DAO;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockOptions;
import org.hibernate.Session;
import org.hibernate.criterion.Example;

import main.java.com.epul.util.HibernateUtil;

public class AbstractHome {

	protected Session session;
	protected String classe;
	protected static final Log log = LogFactory.getLog(AbstractHome.class);
	
	public AbstractHome() {
		session = HibernateUtil.getSessionFactory().getCurrentSession();
	}
	
	protected Session getSession() {
		if(session == null || !session.isOpen()) {
	    	session = HibernateUtil.getSessionFactory().openSession();
		}
		
		return session;
	}
	
	public void persist(Object instance) {
		log.debug("Persisting "+classe+" instance");
		try {
			getSession().beginTransaction();
			getSession().persist(instance);
			getSession().getTransaction().commit();
			log.debug("Persist successful");
		} catch (RuntimeException re) {
			log.error("Persist failed", re);
			throw re;
		} finally {
			getSession().close();
		}
	}
	
	public void attachDirty(Object instance) {
		log.debug("Attaching dirty "+classe+" instance");
		try {
			getSession().beginTransaction();
			getSession().saveOrUpdate(instance);
			getSession().getTransaction().commit();
			log.debug("Attach successful");
		} catch (RuntimeException re) {
			log.error("Attach failed", re);
			throw re;
		} finally {
			getSession().close();
		}
	}
	
	public void attachClean(Object instance) {
		log.debug("Attaching clean "+classe+" instance");
		try {
			getSession().beginTransaction();
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			getSession().getTransaction().commit();
			log.debug("Attach successful");
		} catch (RuntimeException re) {
			log.error("Attach failed", re);
			throw re;
		} finally {
			getSession().close();
		}
	}

	public void delete(Object persistentInstance) {
		log.debug("Deleting "+classe+" instance");
		try {
			getSession().beginTransaction();
			getSession().delete(persistentInstance);
			getSession().flush();
			getSession().clear();
			getSession().getTransaction().commit();
			log.debug("Delete successful");
		} catch (RuntimeException re) {
			log.error("Delete failed", re);
			throw re;
		} finally {
			getSession().close();
		}
	}
	
	public Object merge(Object detachedInstance) {
		log.debug("Merging "+classe+" instance");
		try {
			getSession().beginTransaction();
			Object result = (Object) session.merge(detachedInstance);
			getSession().getTransaction().commit();
			log.debug("Merge successful");
			getSession().close();
			return result;
		} catch (RuntimeException re) {
			log.error("Merge failed", re);
			throw re;
		}
	}
	
	public Object findById(int id) {
		log.debug("Getting "+classe+" instance with id: " + id);
		try {
			getSession().beginTransaction();
			Object instance = session.get("main.java.com.epul.metier."+classe, id);
			getSession().getTransaction().commit();
			if (instance == null) {
				log.debug("Get successful, no instance found");
			} else {
				log.debug("Get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("Get failed", re);
			throw re;
		} finally {
			getSession().close();
		}
	}
	
	@SuppressWarnings("rawtypes")
	public List findByExample(Object instance) {
		log.debug("Finding "+classe+" instance by example");
		try {
			getSession().beginTransaction();
			List results = session.createCriteria("main.java.com.epul.metier."+classe).add(Example.create(instance)).list();
			getSession().getTransaction().commit();
			log.debug("Find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("Find by example failed", re);
			throw re;
		} finally {
			getSession().close();
		}
	}
}
