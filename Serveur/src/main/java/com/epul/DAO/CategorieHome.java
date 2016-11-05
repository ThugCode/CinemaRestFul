package main.java.com.epul.DAO;
// Generated 10 oct. 2016 23:12:26 by Hibernate Tools 4.0.0

import java.util.List;

import main.java.com.epul.metier.Categorie;

/**
 * Home object for domain model class Categorie.
 * @see com.epul.DAO.Categorie
 * @author Hibernate Tools
 */
public class CategorieHome extends AbstractHome {

	public CategorieHome() {
		super();
		classe = "Categorie";
	}

	public List<Categorie> getListCategorie() {
		session.beginTransaction();
		List<Categorie> list = session.createCriteria(Categorie.class).list();
		session.getTransaction().commit();
		return list;
	}
}
