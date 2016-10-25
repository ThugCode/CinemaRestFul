package main.java.com.epul.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import main.java.com.epul.DAO.FilmHome;
import main.java.com.epul.metier.Film;

@Path("/test")
public class WService {
	
	
	/*****************************************************/
	/***************          FILM          **************/
	/*****************************************************/
	@POST
	@Path("/film/ajout/{film}")
	@Produces(MediaType.APPLICATION_XML)	
	public void insertionFilm(Film film) {
		//FilmHome filmDAO = new FilmHome();
		//filmDAO.attachDirty(film);
	}
	
	@GET
	@Path("/film")
	@Produces(MediaType.APPLICATION_XML)
	public List<Film> listeFilms() {
		
		FilmHome filmDAO = new FilmHome();
		return filmDAO.getListFilm();
	}
	

	@GET
	@Path("/film/{Id}")
	@Produces(MediaType.APPLICATION_XML)
	public Film rechercheFilmId(@PathParam("Id")  int idFilm)
	{
		FilmHome filmDAO = new FilmHome();
		return filmDAO.findById(idFilm);
	}
}
