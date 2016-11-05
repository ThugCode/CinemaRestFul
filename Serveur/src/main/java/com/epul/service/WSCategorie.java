package main.java.com.epul.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import main.java.com.epul.DAO.CategorieHome;
import main.java.com.epul.metier.Categorie;

@Path("/categories")
public class WSCategorie {
	
	
	/*****************************************************/
	/***************       CATEGORIE        **************/
	/*****************************************************/
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Categorie> listeCategories() {
		
		CategorieHome categorieDAO = new CategorieHome();	
		return categorieDAO.getListCategorie();
	}
	
	@GET
	@Path("/get/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Categorie getCategorieById(@PathParam("id")  int idCategorie)
	{
		CategorieHome categorieDAO = new CategorieHome();
		return (Categorie) categorieDAO.findById(idCategorie);
	}
	
	@POST
	@Path("/search/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Categorie> searchCategorie(Categorie categorie)
	{
		CategorieHome categorieDAO = new CategorieHome();
		return categorieDAO.findByExample(categorie);
	}
	
	@POST
	@Path("/add/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Categorie insertionCategorie(Categorie categorie) {
		CategorieHome categorieDAO = new CategorieHome();
		categorieDAO.attachDirty(categorie);
		return categorie;
	}
	
	@POST
	@Path("/update/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Categorie miseAJourCategorie(Categorie categorie) {
		CategorieHome categorieDAO = new CategorieHome();
		categorieDAO.merge(categorie);
		return categorie;
	}
	
	@GET
	@Path("/delete/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Categorie suppressionCategorieById(@PathParam("id")  int idCategorie) {
		CategorieHome categorieDAO = new CategorieHome();
		Categorie categorie = (Categorie) categorieDAO.findById(idCategorie);
		if(categorie != null)
			categorieDAO.delete(categorie);
		return categorie;
	}
}
