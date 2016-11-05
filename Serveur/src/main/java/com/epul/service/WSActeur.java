package main.java.com.epul.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import main.java.com.epul.DAO.ActeurHome;
import main.java.com.epul.metier.Acteur;

@Path("/acteurs")
public class WSActeur {
	
	
	/*****************************************************/
	/***************        ACTEUR          **************/
	/*****************************************************/
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Acteur> listeActeurs() {
		
		ActeurHome acteurDAO = new ActeurHome();	
		return acteurDAO.getListActeur();
	}
	
	@GET
	@Path("/get/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Acteur getActeurById(@PathParam("id")  int idActeur)
	{
		ActeurHome acteurDAO = new ActeurHome();
		return (Acteur) acteurDAO.findById(idActeur);
	}
	
	@POST
	@Path("/search/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Acteur> searchActeur(Acteur acteur)
	{
		ActeurHome acteurDAO = new ActeurHome();
		return acteurDAO.findByExample(acteur);
	}
	
	@POST
	@Path("/add/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Acteur insertionActeur(Acteur acteur) {
		ActeurHome acteurDAO = new ActeurHome();
		acteurDAO.attachDirty(acteur);
		return acteur;
	}
	
	@POST
	@Path("/update/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Acteur miseAJourActeur(Acteur acteur) {
		ActeurHome acteurDAO = new ActeurHome();
		acteurDAO.merge(acteur);
		return acteur;
	}
	
	@GET
	@Path("/delete/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Acteur suppressionActeurById(@PathParam("id")  int idActeur) {
		ActeurHome acteurDAO = new ActeurHome();
		Acteur acteur = (Acteur) acteurDAO.findById(idActeur);
		if(acteur != null)
			acteurDAO.delete(acteur);
		return acteur;
	}
}
