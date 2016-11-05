package main.java.com.epul.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import main.java.com.epul.DAO.RealisateurHome;
import main.java.com.epul.metier.Realisateur;

@Path("/realisateurs")
public class WSRealisateur {
	
	
	/*****************************************************/
	/***************      REALISATEUR       **************/
	/*****************************************************/
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Realisateur> listeRealisateurs() {
		
		RealisateurHome realisateurDAO = new RealisateurHome();	
		return realisateurDAO.getListRealisateur();
	}
	
	@GET
	@Path("/get/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Realisateur getRealisateurById(@PathParam("id")  int idRealisateur)
	{
		RealisateurHome realisateurDAO = new RealisateurHome();
		return (Realisateur) realisateurDAO.findById(idRealisateur);
	}
	
	@POST
	@Path("/search/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Realisateur> searchRealisateur(Realisateur realisateur)
	{
		RealisateurHome realisateurDAO = new RealisateurHome();
		return realisateurDAO.findByExample(realisateur);
	}
	
	@POST
	@Path("/add/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Realisateur insertionRealisateur(Realisateur realisateur) {
		RealisateurHome realisateurDAO = new RealisateurHome();
		realisateurDAO.attachDirty(realisateur);
		return realisateur;
	}
	
	@POST
	@Path("/update/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Realisateur miseAJourRealisateur(Realisateur realisateur) {
		RealisateurHome realisateurDAO = new RealisateurHome();
		realisateurDAO.merge(realisateur);
		return realisateur;
	}
	
	@GET
	@Path("/delete/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Realisateur suppressionRealisateurById(@PathParam("id")  int idRealisateur) {
		RealisateurHome realisateurDAO = new RealisateurHome();
		Realisateur realisateur = (Realisateur) realisateurDAO.findById(idRealisateur);
		if(realisateur != null)
			realisateurDAO.delete(realisateur);
		return realisateur;
	}
}
