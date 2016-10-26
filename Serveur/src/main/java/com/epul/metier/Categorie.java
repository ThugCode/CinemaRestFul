package main.java.com.epul.metier;
// Generated 25 oct. 2016 08:43:06 by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Categorie generated by hbm2java
 */
@Entity
@Table(name = "categorie", catalog = "cinema")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Categorie implements java.io.Serializable {
	private static final long serialVersionUID = -64893359793689852L;
	
	@Id
	@Column(name = "CodeCat", unique = true, nullable = false, length = 2)
	private String codeCat;
	@Column(name = "LibelleCat", nullable = false, length = 20)
	private String libelleCat;
	@XmlTransient
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "categorie")
	private Set<Film> films = new HashSet<Film>(0);

	public Categorie() {
	}

	public Categorie(String codeCat, String libelleCat) {
		this.codeCat = codeCat;
		this.libelleCat = libelleCat;
	}

	public Categorie(String codeCat, String libelleCat, Set<Film> films) {
		this.codeCat = codeCat;
		this.libelleCat = libelleCat;
		this.films = films;
	}

	public String getCodeCat() {
		return this.codeCat;
	}

	public void setCodeCat(String codeCat) {
		this.codeCat = codeCat;
	}

	public String getLibelleCat() {
		return this.libelleCat;
	}

	public void setLibelleCat(String libelleCat) {
		this.libelleCat = libelleCat;
	}

	public Set<Film> getFilms() {
		return this.films;
	}

	public void setFilms(Set<Film> films) {
		this.films = films;
	}

}
