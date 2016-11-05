package main.java.com.epul.service;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

// adresse de base pour accéder au WS
@ApplicationPath("/")
public class WSApplication extends Application {
	private Set<Object> singletons = new HashSet<Object>();
	private Set<Class<?>> empty = new HashSet<Class<?>>();
	
	public WSApplication() {
		singletons.add(new WSActeur());
		singletons.add(new WSCategorie());
		singletons.add(new WSFilm());
		singletons.add(new WSPersonnage());
		singletons.add(new WSRealisateur());
	}
	
	@Override
	public Set<Class<?>> getClasses() {
		return empty;
	}
	
	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}
}
