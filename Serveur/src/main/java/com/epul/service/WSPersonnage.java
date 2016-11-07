package main.java.com.epul.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import main.java.com.epul.DAO.PersonnageHome;
import main.java.com.epul.metier.Personnage;
import main.java.com.epul.metier.PersonnageId;

@Path("/personnages")
public class WSPersonnage {
	
	
	/*****************************************************/
	/***************       PERSONNAGE       **************/
	/*****************************************************/
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Personnage> listePersonnages() {
		
		PersonnageHome personnageDAO = new PersonnageHome();	
		return personnageDAO.getListPersonnage();
	}
	
	@GET
	@Path("/get/{idFilm}/{idActeur}")
	@Produces(MediaType.APPLICATION_JSON)
	public Personnage getPersonnageById(@PathParam("idFilm")  int idFilm, @PathParam("idActeur") int idActeur)
	{
		PersonnageId id = new PersonnageId(idFilm, idActeur);
		PersonnageHome personnageDAO = new PersonnageHome();
		return (Personnage) personnageDAO.findById(id);
	}
	
	@POST
	@Path("/search/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Personnage> searchPersonnage(Personnage personnage)
	{
		PersonnageHome personnageDAO = new PersonnageHome();
		return personnageDAO.findByExample(personnage);
	}
	
	@POST
	@Path("/add/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Personnage insertionPersonnage(Personnage personnage) {
		PersonnageHome personnageDAO = new PersonnageHome();
		personnageDAO.attachDirty(personnage);
		return personnage;
	}
	
	@POST
	@Path("/update/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Personnage miseAJourPersonnage(Personnage personnage) {
		PersonnageHome personnageDAO = new PersonnageHome();
		personnageDAO.merge(personnage);
		return personnage;
	}
	
	@GET
	@Path("/delete/{idFilm}/{idActeur}")
	@Produces(MediaType.APPLICATION_JSON)
	public Personnage suppressionPersonnageById(@PathParam("idFilm")  int idFilm, @PathParam("idActeur") int idActeur) {
		
		PersonnageId id = new PersonnageId(idFilm, idActeur);
		PersonnageHome personnageDAO = new PersonnageHome();
		Personnage personnage = (Personnage) personnageDAO.findById(id);
		if(personnage != null)
			personnageDAO.delete(personnage);
		return personnage;
	}
}
