package main.java.com.epul.metier;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-10-29T10:50:49.409+0200")
@StaticMetamodel(Realisateur.class)
public class Realisateur_ {
	public static volatile SingularAttribute<Realisateur, Integer> noRea;
	public static volatile SingularAttribute<Realisateur, String> nomRea;
	public static volatile SingularAttribute<Realisateur, String> prenRea;
	public static volatile SetAttribute<Realisateur, Film> films;
}
