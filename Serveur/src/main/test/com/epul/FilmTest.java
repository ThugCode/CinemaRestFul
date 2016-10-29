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
		
		System.out.println("");
		System.out.println("SERVER REQUEST : LIST");
		System.out.println("");
		
		WebResource webResource = client.resource("http://localhost:8080/CinemaRestFulServeur/test/films");
		ClientResponse response = webResource.type(MediaType.APPLICATION_JSON).get(ClientResponse.class);

		System.out.println("Server response : \n"+response.getEntity(String.class));
		
		assertTrue(response.getStatus() == 200);
	}
	
	@Test
	public void testAdd() {
		
		System.out.println("");
		System.out.println("SERVER REQUEST : ADD");
		System.out.println("");
		
		WebResource webResource = client.resource("http://localhost:8080/CinemaRestFulServeur/test/films/add/");
		ClientResponse response = webResource.type(MediaType.APPLICATION_JSON).post(ClientResponse.class, filmToTest);
		
		System.out.println("Server response : \n"+response.getEntity(String.class));
		
		assertTrue(response.getStatus() == 200);
	}
	
	@Test
	public void testAddDuplicateEntry() {
		
		System.out.println("");
		System.out.println("SERVER REQUEST : ADD DUPLICATE");
		System.out.println("");
		
		WebResource webResource = client.resource("http://localhost:8080/CinemaRestFulServeur/test/films/add/");
		ClientResponse response = webResource.type(MediaType.APPLICATION_JSON).post(ClientResponse.class, filmToTest);
		
		assertTrue(response.getEntity(String.class).contains("Duplicate entry"));
	}
	
	@Test
	public void testUpdate() {
		
		System.out.println("");
		System.out.println("SERVER REQUEST : UPDATE");
		System.out.println("");
		
		filmToTest.setTitre("Patachou");
		
		WebResource webResource = client.resource("http://localhost:8080/CinemaRestFulServeur/test/films/update/");
		ClientResponse response = webResource.type(MediaType.APPLICATION_JSON).post(ClientResponse.class, filmToTest);
		
		System.out.println("Server response : \n"+response.getEntity(String.class));

		assertTrue(response.getStatus() == 200);
	}
	
	@Test
	public void testUpdateFalse() {
		
		System.out.println("");
		System.out.println("SERVER REQUEST : UPDATE FALSE");
		System.out.println("");
		
		filmToTest.setNoFilm(13);
		filmToTest.setTitre("Patachou");
		
		WebResource webResource = client.resource("http://localhost:8080/CinemaRestFulServeur/test/films/update/");
		ClientResponse response = webResource.type(MediaType.APPLICATION_JSON).post(ClientResponse.class, filmToTest);
		
		System.out.println("Server response : \n"+response.getEntity(String.class));

		assertTrue(response.getStatus() == 200);
	}
	
	@Test
	public void testGet() {
		
		System.out.println("");
		System.out.println("SERVER REQUEST : GET");
		System.out.println("");
		
		WebResource webResource = client.resource("http://localhost:8080/CinemaRestFulServeur/test/films/get/"+filmToTest.getNoFilm());
		ClientResponse response = webResource.type(MediaType.APPLICATION_JSON).get(ClientResponse.class);
		
		System.out.println("Server response : \n"+response.getEntity(String.class));

		assertTrue(response.getStatus() == 200);
	}
	
	@Test
	public void testGetFalse() {
		
		System.out.println("");
		System.out.println("SERVER REQUEST : GET FALSE");
		System.out.println("");
		
		WebResource webResource = client.resource("http://localhost:8080/CinemaRestFulServeur/test/films/get/14");
		ClientResponse response = webResource.type(MediaType.APPLICATION_JSON).get(ClientResponse.class);
		
		System.out.println("Server response : \n"+response.getEntity(String.class));

		assertTrue(response.getStatus() == 200);
	}
	
	@Test
	public void testSearch() {
		
		System.out.println("");
		System.out.println("SERVER REQUEST : SEARCH");
		System.out.println("");
		
		WebResource webResource = client.resource("http://localhost:8080/CinemaRestFulServeur/test/films/search/");
		ClientResponse response = webResource.type(MediaType.APPLICATION_JSON).post(ClientResponse.class, filmToTest);
		
		System.out.println("Server response : \n"+response.getEntity(String.class));

		assertTrue(response.getStatus() == 200);
	}
	
	@Test
	public void testDelete() {
		
		System.out.println("");
		System.out.println("SERVER REQUEST : DELETE");
		System.out.println("");
		
		WebResource webResource = client.resource("http://localhost:8080/CinemaRestFulServeur/test/films/delete/"+filmToTest.getNoFilm());
		ClientResponse response = webResource.type(MediaType.APPLICATION_JSON).get(ClientResponse.class);
		
		System.out.println("Server response : \n"+response.getEntity(String.class));

		assertTrue(response.getStatus() == 200);
	}
}
