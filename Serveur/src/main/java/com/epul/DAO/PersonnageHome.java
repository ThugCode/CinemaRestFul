package main.java.com.epul.DAO;
// Generated 10 oct. 2016 23:12:26 by Hibernate Tools 4.0.0

import java.util.List;

import main.java.com.epul.metier.Personnage;

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
}
