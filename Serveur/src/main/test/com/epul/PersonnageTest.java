package main.test.com.epul;

import static org.junit.Assert.assertTrue;

import java.util.Date;

import javax.ws.rs.core.MediaType;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import main.java.com.epul.metier.Acteur;
import main.java.com.epul.metier.Categorie;
import main.java.com.epul.metier.Film;
import main.java.com.epul.metier.Personnage;
import main.java.com.epul.metier.PersonnageId;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PersonnageTest {

	private Personnage personnageToTest;
	private Client client;
	
	private static Film persistFilm;
	private static Acteur persistActeur;
	
	@Before
	public void setUp() throws Exception {
		
		personnageToTest = new Personnage(new PersonnageId(4, 1), 
				new Acteur(),
				new Film(),
				"Le boss"
			);
		
		client = Client.create();
	}

	@Test
	public void test1List() {
		
		System.out.println("");
		System.out.println("SERVER REQUEST : LIST");
		System.out.println("");
		
		WebResource webResource = client.resource("http://localhost:8080/CinemaRestFulServeur/personnages");
		ClientResponse response = webResource.type(MediaType.APPLICATION_JSON).get(ClientResponse.class);

		System.out.println("Server response : \n"+response.getEntity(String.class));
		
		assertTrue(response.getStatus() == 200);
	}
	
	@Test
	public void test2Add() {
		
		System.out.println("");
		System.out.println("SERVER REQUEST : ADD");
		System.out.println("");
		
		WebResource webRes = client.resource("http://localhost:8080/CinemaRestFulServeur/films/get/4");
		ClientResponse res = webRes.type(MediaType.APPLICATION_JSON).get(ClientResponse.class);
		
		personnageToTest.setFilm(res.getEntity(Film.class));
		persistFilm = personnageToTest.getFilm();
		
		WebResource webRes2 = client.resource("http://localhost:8080/CinemaRestFulServeur/acteurs/get/1");
		ClientResponse res2 = webRes2.type(MediaType.APPLICATION_JSON).get(ClientResponse.class);
		
		personnageToTest.setActeur(res2.getEntity(Acteur.class));
		persistActeur = personnageToTest.getActeur();
		
		WebResource webResource = client.resource("http://localhost:8080/CinemaRestFulServeur/personnages/add/");
		ClientResponse response = webResource.type(MediaType.APPLICATION_JSON).post(ClientResponse.class, personnageToTest);
		
		System.out.println("Server response : \n"+response.getEntity(String.class));
		
		assertTrue(response.getStatus() == 200);
	}
	
	@Test
	public void test3Update() {
		
		System.out.println("");
		System.out.println("SERVER REQUEST : UPDATE");
		System.out.println("");
		
		personnageToTest.setFilm(persistFilm);
		personnageToTest.setActeur(persistActeur);
		personnageToTest.setNomPers("Le chef");
		
		WebResource webResource = client.resource("http://localhost:8080/CinemaRestFulServeur/personnages/update/");
		ClientResponse response = webResource.type(MediaType.APPLICATION_JSON).post(ClientResponse.class, personnageToTest);
		
		System.out.println("Server response : \n"+response.getEntity(String.class));

		assertTrue(response.getStatus() == 200);
	}
	
	@Test
	public void test4Get() {
		
		System.out.println("");
		System.out.println("SERVER REQUEST : GET");
		System.out.println("");
		
		WebResource webResource = client.resource("http://localhost:8080/CinemaRestFulServeur/personnages/get/"
									+persistFilm.getNoFilm()+"/"+persistActeur.getNoAct());
		ClientResponse response = webResource.type(MediaType.APPLICATION_JSON).get(ClientResponse.class);
		
		System.out.println("Server response : \n"+response.getEntity(String.class));

		assertTrue(response.getStatus() == 200);
	}
	
	@Test
	public void test5GetNoContent() {
		
		System.out.println("");
		System.out.println("SERVER REQUEST : GET NO CONTENT");
		System.out.println("");
		
		personnageToTest.setFilm(persistFilm);
		personnageToTest.setActeur(persistActeur);
		
		WebResource webResource = client.resource("http://localhost:8080/CinemaRestFulServeur/personnages/get/14/12");
		ClientResponse response = webResource.type(MediaType.APPLICATION_JSON).get(ClientResponse.class);
		
		System.out.println("Server response : \n "+response);
		
		assertTrue(response.toString().contains("204 No Content"));
	}
	
	@Test
	public void test6Search() {
		
		System.out.println("");
		System.out.println("SERVER REQUEST : SEARCH");
		System.out.println("");
		
		Personnage example= new Personnage();
		example.setNomPers("%boss%");
		
		WebResource webResource = client.resource("http://localhost:8080/CinemaRestFulServeur/personnages/search/");
		ClientResponse response = webResource.type(MediaType.APPLICATION_JSON).post(ClientResponse.class, example);
		
		System.out.println("Server response : \n"+response.getEntity(String.class));

		assertTrue(response.getStatus() == 200);
	}
	
	@Test
	public void test7Delete() {
		
		System.out.println("");
		System.out.println("SERVER REQUEST : DELETE");
		System.out.println("");
		
		WebResource webResource = client.resource("http://localhost:8080/CinemaRestFulServeur/personnages/delete/"
									+persistFilm.getNoFilm()+"/"+persistActeur.getNoAct());
		ClientResponse response = webResource.type(MediaType.APPLICATION_JSON).get(ClientResponse.class);
		
		System.out.println("Server response : \n"+response.getEntity(String.class));

		assertTrue(response.getStatus() == 200);
	}
}
