package main.test.com.epul;

import static org.junit.Assert.assertTrue;

import java.util.Date;

import javax.ws.rs.core.MediaType;

import org.junit.Before;
import org.junit.Test;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import main.java.com.epul.metier.Categorie;
import main.java.com.epul.metier.Film;
import main.java.com.epul.metier.Realisateur;

public class FilmTest {

	private Film filmToTest;
	private Client client;
	
	@Before
	public void setUp() throws Exception {
		
		filmToTest = new Film(12, 
				new Categorie("PO", "Policier"),
				new Realisateur(2, "Chabrol", "Claude"),
				"La pistache",
				110,
				new Date(),
				1000000,
				1000000);
		
		client = Client.create();
	}

	@Test
	public void testList() {
		
		try {
			WebResource webResource = client.resource("http://localhost:8080/CinemaRestFulServeur/test/films");
			ClientResponse response = webResource.type(MediaType.APPLICATION_XML).get(ClientResponse.class);

			System.out.println("Server response : \n"+response.getEntity(String.class));
			
			assertTrue(response.getStatus() == 200);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testAdd() {
		
		try {

			WebResource webResource = client.resource("http://localhost:8080/CinemaRestFulServeur/test/films/add/");
			ClientResponse response = webResource.type(MediaType.APPLICATION_XML).post(ClientResponse.class, filmToTest);
			
			System.out.println("Server response : \n"+response.getEntity(String.class));
			
			assertTrue(response.getStatus() == 200);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testUpdate() {
		
		filmToTest.setTitre("Patachou");
		
		try {

			WebResource webResource = client.resource("http://localhost:8080/CinemaRestFulServeur/test/films/update/");
			ClientResponse response = webResource.type(MediaType.APPLICATION_XML).post(ClientResponse.class, filmToTest);
			
			System.out.println("Server response : \n"+response.getEntity(String.class));

			assertTrue(response.getStatus() == 200);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGet() {
		
		try {

			WebResource webResource = client.resource("http://localhost:8080/CinemaRestFulServeur/test/films/get/"+filmToTest.getNoFilm());
			ClientResponse response = webResource.type(MediaType.APPLICATION_XML).get(ClientResponse.class);
			
			System.out.println("Server response : \n"+response.getEntity(String.class));

			assertTrue(response.getStatus() == 200);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testSearch() {
		
		try {

			WebResource webResource = client.resource("http://localhost:8080/CinemaRestFulServeur/test/films/search/");
			ClientResponse response = webResource.type(MediaType.APPLICATION_XML).post(ClientResponse.class, filmToTest);
			
			System.out.println("Server response : \n"+response.getEntity(String.class));

			assertTrue(response.getStatus() == 200);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testDelete() {
		
		try {
			
			WebResource webResource = client.resource("http://localhost:8080/CinemaRestFulServeur/test/films/delete/"+filmToTest.getNoFilm());
			ClientResponse response = webResource.type(MediaType.APPLICATION_XML).get(ClientResponse.class);
			
			System.out.println("Server response : \n"+response.getEntity(String.class));

			assertTrue(response.getStatus() == 200);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
