
import java.util.Date;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class JerseyClient {

	public static void main(String[] args) {
		try {

			Film st = new Film(12, 
					new Categorie("PO", "Policier"),
					new Realisateur(2, "Chabrol", "Claude"),
					"La pistache",
					110,
					new Date(),
					1000000,
					1000000);

			Client client = Client.create();

			//Liste
			//WebResource webResource = client.resource("http://localhost:8080/CinemaRestFulServeur/test/films");
			//ClientResponse response = webResource.type(MediaType.APPLICATION_XML).get(ClientResponse.class);

			//Ajout
			WebResource webResource = client.resource("http://localhost:8080/CinemaRestFulServeur/test/films/add/");
			ClientResponse response = webResource.type(MediaType.APPLICATION_XML).post(ClientResponse.class, st);
			
			//Delete
			//WebResource webResource = client.resource("http://localhost:8080/CinemaRestFulServeur/test/films/get/12");
			//ClientResponse response = webResource.type(MediaType.APPLICATION_XML).get(ClientResponse.class);
			
			//Update
			//WebResource webResource = client.resource("http://localhost:8080/CinemaRestFulServeur/test/films/update/");
			//ClientResponse response = webResource.type(MediaType.APPLICATION_XML).post(ClientResponse.class, st);
			
			//Search
			//WebResource webResource = client.resource("http://localhost:8080/CinemaRestFulServeur/test/films/search/");
			//ClientResponse response = webResource.type(MediaType.APPLICATION_XML).post(ClientResponse.class, st);
			
			//Delete
			//WebResource webResource = client.resource("http://localhost:8080/CinemaRestFulServeur/test/films/delete/12");
			//ClientResponse response = webResource.type(MediaType.APPLICATION_XML).get(ClientResponse.class);
			
			
			//Ajout, update, delete renvoient des erreurs 204 parce que je renvois rien depuis le serveur, mais ça marche
			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "+ response.getStatus());
			}

			String output = response.getEntity(String.class);

			System.out.println("Server response : \n");
			System.out.println(output);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}