package main.java.com.epul.metier;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-10-25T08:43:06.892+0200")
@StaticMetamodel(Personnage.class)
public class Personnage_ {
	public static volatile SingularAttribute<Personnage, PersonnageId> id;
	public static volatile SingularAttribute<Personnage, Acteur> acteur;
	public static volatile SingularAttribute<Personnage, Film> film;
	public static volatile SingularAttribute<Personnage, String> nomPers;
}
