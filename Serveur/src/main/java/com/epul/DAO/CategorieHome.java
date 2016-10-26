package main.java.com.epul.DAO;
// Generated 10 oct. 2016 23:12:26 by Hibernate Tools 4.0.0

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.criterion.Example;

import main.java.com.epul.metier.Categorie;
import main.java.com.epul.metier.Film;

/**
 * Home object for domain model class Categorie.
 * @see com.epul.DAO.Categorie
 * @author Hibernate Tools
 */
public class CategorieHome extends AbstractHome {

	private static final Log log = LogFactory.getLog(CategorieHome.class);

	public CategorieHome() {
		super();
	}

	public void persist(Categorie transientInstance) {
		log.debug("persisting Categorie instance");
		try {
			session.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Categorie instance) {
		log.debug("attaching dirty Categorie instance");
		try {
			session.saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Categorie instance) {
		log.debug("attaching clean Categorie instance");
		try {
			session.lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	
	public List<Categorie> getListCategorie() {
		session.beginTransaction();
		List<Categorie> list = session.createCriteria(Categorie.class).list();
		session.getTransaction().commit();
		return list;
	}

	public void delete(Categorie persistentInstance) {
		log.debug("deleting Categorie instance");
		try {
			session.delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Categorie merge(Categorie detachedInstance) {
		log.debug("merging Categorie instance");
		try {
			Categorie result = (Categorie) session.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Categorie findById(java.lang.String id) {
		log.debug("getting Categorie instance with id: " + id);
		try {
			Categorie instance = (Categorie) session.get("main.java.com.epul.metier.Categorie", id);
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

	public List findByExample(Categorie instance) {
		log.debug("finding Categorie instance by example");
		try {
			List results = session.createCriteria("main.java.com.epul.metier.Categorie")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
