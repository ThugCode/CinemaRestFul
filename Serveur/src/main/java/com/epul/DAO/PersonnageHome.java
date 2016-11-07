package main.java.com.epul.DAO;
// Generated 10 oct. 2016 23:12:26 by Hibernate Tools 4.0.0

import java.util.List;

import main.java.com.epul.metier.Personnage;
import main.java.com.epul.metier.PersonnageId;

/**
 * Home object for domain model class Personnage.
 * @see com.epul.DAO.Personnage
 * @author Hibernate Tools
 */
public class PersonnageHome extends AbstractHome {

	public PersonnageHome() {
		super();
		classe = "Personnage";
	}
	
	public List<Personnage> getListPersonnage() {
		getSession().beginTransaction();
		List<Personnage> list = session.createCriteria(Personnage.class).list();
		getSession().getTransaction().commit();
		getSession().close();
		return list;
	}
	
	public Personnage findById(PersonnageId id) {
		log.debug("Getting Personnage instance with id: " + id);
		try {
			getSession().beginTransaction();
			Personnage instance = (Personnage) session.get("main.java.com.epul.metier.Personnage", id);
			getSession().getTransaction().commit();
			if (instance == null) {
				log.debug("Get successful, no instance found");
			} else {
				log.debug("Get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		} finally {
			getSession().close();
		}
	}
}
