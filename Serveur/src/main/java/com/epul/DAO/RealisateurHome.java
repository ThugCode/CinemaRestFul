package main.java.com.epul.DAO;
// Generated 10 oct. 2016 23:12:26 by Hibernate Tools 4.0.0

import java.util.List;

import main.java.com.epul.metier.Realisateur;

/**
 * Home object for domain model class Realisateur.
 * @see com.epul.DAO.Realisateur
 * @author Hibernate Tools
 */
public class RealisateurHome extends AbstractHome {

	public RealisateurHome() {
		super();
		classe = "Realisateur";
	}
	
	public List<Realisateur> getListRealisateur() {
		getSession().beginTransaction();
		List<Realisateur> list = session.createCriteria(Realisateur.class).list();
		getSession().getTransaction().commit();
		getSession().close();
		return list;
	}
}
