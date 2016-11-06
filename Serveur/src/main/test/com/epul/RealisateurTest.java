package main.test.com.epul;

import static org.junit.Assert.assertTrue;

import javax.ws.rs.core.MediaType;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import main.java.com.epul.metier.Categorie;
import main.java.com.epul.metier.Realisateur;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RealisateurTest {

	private Realisateur realisateurToTest;
	private Client client;
	
	@Before
	public void setUp() throws Exception {
		
		realisateurToTest = new Realisateur(10000, 
				"Letourneur",
				"Léo"
			);
		
		client = Client.create();
	}

	@Test
	public void test1List() {
		
		System.out.println("");
		System.out.println("SERVER REQUEST : LIST");
		System.out.println("");
		
		WebResource webResource = client.resource("http://localhost:8080/CinemaRestFulServeur/realisateurs");
		ClientResponse response = webResource.type(MediaType.APPLICATION_JSON).get(ClientResponse.class);

		System.out.println("Server response : \n"+response.getEntity(String.class));
		
		assertTrue(response.getStatus() == 200);
	}
	
	@Test
	public void test2Add() {
		
		System.out.println("");
		System.out.println("SERVER REQUEST : ADD");
		System.out.println("");
		
		WebResource webResource = client.resource("http://localhost:8080/CinemaRestFulServeur/realisateurs/add/");
		ClientResponse response = webResource.type(MediaType.APPLICATION_JSON).post(ClientResponse.class, realisateurToTest);
		
		System.out.println("Server response : \n"+response.getEntity(String.class));
		
		assertTrue(response.getStatus() == 200);
	}
	
	@Test
	public void test3Update() {
		
		System.out.println("");
		System.out.println("SERVER REQUEST : UPDATE");
		System.out.println("");
		
		realisateurToTest.setNomRea("Latourneur");
		
		WebResource webResource = client.resource("http://localhost:8080/CinemaRestFulServeur/realisateurs/update/");
		ClientResponse response = webResource.type(MediaType.APPLICATION_JSON).post(ClientResponse.class, realisateurToTest);
		
		System.out.println("Server response : \n"+response.getEntity(String.class));

		assertTrue(response.getStatus() == 200);
	}
	
	@Test
	public void test4Get() {
		
		System.out.println("");
		System.out.println("SERVER REQUEST : GET");
		System.out.println("");
		
		WebResource webResource = client.resource("http://localhost:8080/CinemaRestFulServeur/realisateurs/get/"+realisateurToTest.getNoRea());
		ClientResponse response = webResource.type(MediaType.APPLICATION_JSON).get(ClientResponse.class);
		
		System.out.println("Server response : \n"+response.getEntity(String.class));

		assertTrue(response.getStatus() == 200);
	}
	
	@Test
	public void test5GetNoContent() {
		
		System.out.println("");
		System.out.println("SERVER REQUEST : GET NO CONTENT");
		System.out.println("");
		
		WebResource webResource = client.resource("http://localhost:8080/CinemaRestFulServeur/realisateurs/get/14");
		ClientResponse response = webResource.type(MediaType.APPLICATION_JSON).get(ClientResponse.class);
		
		System.out.println("Server response : \n "+response);
		
		assertTrue(response.toString().contains("204 No Content"));
		
		
	}
	
	@Test
	public void test6Search() {
		
		System.out.println("");
		System.out.println("SERVER REQUEST : SEARCH");
		System.out.println("");
		
		Categorie example= new Categorie();
		example.setLibelleCat("%olici%");
		
		WebResource webResource = client.resource("http://localhost:8080/CinemaRestFulServeur/realisateurs/search/");
		ClientResponse response = webResource.type(MediaType.APPLICATION_JSON).post(ClientResponse.class, example);
		
		System.out.println("Server response : \n"+response.getEntity(String.class));

		assertTrue(response.getStatus() == 200);
	}
	
	@Test
	public void test7Delete() {
		
		System.out.println("");
		System.out.println("SERVER REQUEST : DELETE");
		System.out.println("");
		
		WebResource webResource = client.resource("http://localhost:8080/CinemaRestFulServeur/realisateurs/delete/"+realisateurToTest.getNoRea());
		ClientResponse response = webResource.type(MediaType.APPLICATION_JSON).get(ClientResponse.class);
		
		System.out.println("Server response : \n"+response.getEntity(String.class));

		assertTrue(response.getStatus() == 200);
	}
}
