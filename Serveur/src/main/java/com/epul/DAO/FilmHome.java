package main.java.com.epul.DAO;
// Generated 10 oct. 2016 23:12:26 by Hibernate Tools 4.0.0

import java.util.List;

import javax.naming.InitialContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import main.java.com.epul.metier.Film;
import main.java.com.epul.util.HibernateUtil;

/**
 * Home object for domain model class Film.
 * @see com.epul.DAO.Film
 * @author Hibernate Tools
 */
public class FilmHome {

	private static final Log log = LogFactory.getLog(FilmHome.class);

	public void persist(Film transientInstance) {
		log.debug("persisting Film instance");
		try {
			HibernateUtil.getSessionFactory().getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Film instance) {
		log.debug("attaching dirty Film instance");
		try {
			HibernateUtil.getSessionFactory().getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Film instance) {
		log.debug("attaching clean Film instance");
		try {
			HibernateUtil.getSessionFactory().getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public List<Film> getListFilm() {
		return HibernateUtil.getSessionFactory().getCurrentSession().createCriteria(Film.class).list();
	}
	
	public void delete(Film persistentInstance) {
		log.debug("deleting Film instance");
		try {
			HibernateUtil.getSessionFactory().getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Film merge(Film detachedInstance) {
		log.debug("merging Film instance");
		try {
			Film result = (Film) HibernateUtil.getSessionFactory().getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Film findById(int id) {
		log.debug("getting Film instance with id: " + id);
		try {
			Film instance = (Film) HibernateUtil.getSessionFactory().getCurrentSession().get("com.epul.DAO.Film", id);
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Film instance) {
		log.debug("finding Film instance by example");
		try {
			List results = HibernateUtil.getSessionFactory().getCurrentSession().createCriteria("com.epul.DAO.Film")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
