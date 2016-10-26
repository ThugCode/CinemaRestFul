package main.java.com.epul.metier;
// Generated 25 oct. 2016 08:43:06 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * PersonnageId generated by hbm2java
 */
@Embeddable
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class PersonnageId implements java.io.Serializable {
	private static final long serialVersionUID = -2241491997506233960L;
	
	@Column(name = "NoFilm", nullable = false)
	private int noFilm;
	@Column(name = "NoAct", nullable = false)
	private int noAct;

	public PersonnageId() {
	}

	public PersonnageId(int noFilm, int noAct) {
		this.noFilm = noFilm;
		this.noAct = noAct;
	}

	public int getNoFilm() {
		return this.noFilm;
	}

	public void setNoFilm(int noFilm) {
		this.noFilm = noFilm;
	}

	public int getNoAct() {
		return this.noAct;
	}

	public void setNoAct(int noAct) {
		this.noAct = noAct;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof PersonnageId))
			return false;
		PersonnageId castOther = (PersonnageId) other;

		return (this.getNoFilm() == castOther.getNoFilm()) && (this.getNoAct() == castOther.getNoAct());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getNoFilm();
		result = 37 * result + this.getNoAct();
		return result;
	}

}