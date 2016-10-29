package main.java.com.epul.metier;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-10-29T10:47:43.807+0200")
@StaticMetamodel(Acteur.class)
public class Acteur_ {
	public static volatile SingularAttribute<Acteur, Integer> noAct;
	public static volatile SingularAttribute<Acteur, String> nomAct;
	public static volatile SingularAttribute<Acteur, String> prenAct;
	public static volatile SingularAttribute<Acteur, Date> dateNaiss;
	public static volatile SingularAttribute<Acteur, Date> dateDeces;
	public static volatile SetAttribute<Acteur, Personnage> personnages;
}
