package main.java.com.epul.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.google.gson.Gson;

import main.java.com.epul.DAO.FilmHome;
import main.java.com.epul.metier.Film;

@Path("/mediatheque")
public class WService {
	
	
	/*****************************************************/
	/***************          FILM          **************/
	/*****************************************************/
	@POST
	@Path("/Film/ajout/{film}")
	@Consumes("application/json")	
	public void insertionFilm(String aFilm) {
		FilmHome filmDAO = new FilmHome();
		Gson gson = new Gson();
		Film film = (Film) gson.fromJson(aFilm, Film.class);
		filmDAO.attachDirty(film);
	}
	
	@GET
	@Path("/Film")
	@Produces("application/json")
	public String listeFilms() {
		
		FilmHome filmDAO = new FilmHome();
		List<Film> listeFilms = filmDAO.getListFilm();
		
		Gson gson = new Gson();
		return gson.toJson(listeFilms);
	}

	@GET
	@Path("/Film/{Id}")
	@Produces("application/json")
	public String rechercheFilmId(@PathParam("Id")  String idFilm)
	{
		FilmHome filmDAO = new FilmHome();
		Gson gson = new Gson();
		return gson.toJson(filmDAO.findById(Integer.parseInt(idFilm)));
	}
}
