package main.java.com.epul.DAO;
// Generated 10 oct. 2016 23:12:26 by Hibernate Tools 4.0.0

import java.util.List;

import main.java.com.epul.metier.Acteur;

/**
 * Home object for domain model class Acteur.
 * @see com.epul.DAO.Acteur
 * @author Hibernate Tools
 */
public class ActeurHome extends AbstractHome {

	public ActeurHome() {
		super();
		classe = "Acteur";
	}
	
	public List<Acteur> getListActeur() {
		getSession().beginTransaction();
		List<Acteur> list = session.createCriteria(Acteur.class).list();
		getSession().getTransaction().commit();
		getSession().close();
		return list;
	}
}
