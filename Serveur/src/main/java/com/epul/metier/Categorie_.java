package main.java.com.epul.metier;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-10-25T08:43:06.890+0200")
@StaticMetamodel(Categorie.class)
public class Categorie_ {
	public static volatile SingularAttribute<Categorie, String> codeCat;
	public static volatile SingularAttribute<Categorie, String> libelleCat;
	public static volatile SetAttribute<Categorie, Film> films;
}
