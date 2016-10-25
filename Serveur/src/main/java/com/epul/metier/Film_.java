package main.java.com.epul.metier;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-10-25T08:43:06.891+0200")
@StaticMetamodel(Film.class)
public class Film_ {
	public static volatile SingularAttribute<Film, Integer> noFilm;
	public static volatile SingularAttribute<Film, Categorie> categorie;
	public static volatile SingularAttribute<Film, Realisateur> realisateur;
	public static volatile SingularAttribute<Film, String> titre;
	public static volatile SingularAttribute<Film, Integer> duree;
	public static volatile SingularAttribute<Film, Date> dateSortie;
	public static volatile SingularAttribute<Film, Integer> budget;
	public static volatile SingularAttribute<Film, Integer> montantRecette;
	public static volatile SetAttribute<Film, Personnage> personnages;
}
