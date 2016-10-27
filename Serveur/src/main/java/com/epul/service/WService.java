package main.java.com.epul.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import main.java.com.epul.metier.Categorie;
import main.java.com.epul.DAO.CategorieHome;
import main.java.com.epul.DAO.FilmHome;
import main.java.com.epul.metier.Film;

@Path("/test")
public class WService {
	
	
	/*****************************************************/
	/***************          FILM          **************/
	/*****************************************************/
	@GET
	@Path("/films")
	@Produces(MediaType.APPLICATION_XML)
	public List<Film> listeFilms() {
		
		FilmHome filmDAO = new FilmHome();
		return filmDAO.getListFilm();
	}
	
	@GET
	@Path("/films/get/{id}")
	@Produces(MediaType.APPLICATION_XML)
	public Film getFilmById(@PathParam("id")  int idFilm)
	{
		FilmHome filmDAO = new FilmHome();
		return filmDAO.findById(idFilm);
	}
	
	@POST
	@Path("/films/search/")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public List<Film> searchFilm(Film film)
	{
		FilmHome filmDAO = new FilmHome();
		return filmDAO.findByExample(film);
	}
	
	@POST
	@Path("/films/add/")
	@Consumes(MediaType.APPLICATION_XML)	
	public void insertionFilm(Film film) {
		FilmHome filmDAO = new FilmHome();
		filmDAO.attachDirty(film);
	}
	
	@POST
	@Path("/films/update/")
	@Consumes(MediaType.APPLICATION_XML)	
	public void miseAJourFilm(Film film) {
		FilmHome filmDAO = new FilmHome();
		filmDAO.merge(film);
	}
	
	@GET
	@Path("/films/delete/{id}")
	@Produces(MediaType.APPLICATION_XML)
	public void suppressionFilmById(@PathParam("id")  int idFilm) {
		FilmHome filmDAO = new FilmHome();
		Film film = filmDAO.findById(idFilm);
		if(film != null)
			filmDAO.delete(film);
	}
	
	
	/*****************************************************/
	/***************       CATEGORIE        **************/
	/*****************************************************/
	@GET
	@Path("/categorie")
	@Produces(MediaType.APPLICATION_XML)
	public List<Categorie> listCategorie() {
		
		CategorieHome categorieDAO = new CategorieHome();
		return categorieDAO.getListCategorie();
	}
}
