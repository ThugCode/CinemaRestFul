package main.java.com.epul.metier;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-10-29T10:48:25.373+0200")
@StaticMetamodel(Categorie.class)
public class Categorie_ {
	public static volatile SingularAttribute<Categorie, String> codeCat;
	public static volatile SingularAttribute<Categorie, String> libelleCat;
	public static volatile SetAttribute<Categorie, Film> films;
}
