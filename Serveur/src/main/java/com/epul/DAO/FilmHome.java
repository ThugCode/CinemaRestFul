package main.java.com.epul.DAO;
// Generated 10 oct. 2016 23:12:26 by Hibernate Tools 4.0.0

import java.util.List;

import main.java.com.epul.metier.Film;

/**
 * Home object for domain model class Film.
 * @see com.epul.DAO.Film
 * @author Hibernate Tools
 */
public class FilmHome extends AbstractHome {
	
	public FilmHome() {
		super();
		classe = "Film";
	}
	
	public List<Film> getListFilm() {
		getSession().beginTransaction();
		List<Film> list = session.createCriteria(Film.class).list();
		getSession().getTransaction().commit();
		getSession().close();
		return list;
	}
}
