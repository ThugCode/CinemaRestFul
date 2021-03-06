package main.java.com.epul.metier;
// Generated 25 oct. 2016 08:43:06 by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import main.java.com.epul.util.DateFormater;

/**
 * Film generated by hbm2java
 */
@Entity
@Table(name = "film", catalog = "cinema")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Film implements java.io.Serializable {
	private static final long serialVersionUID = -4158730546766376186L;
	
	@Id
	@Column(name = "NoFilm", unique = true, nullable = false)
	private int noFilm;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CodeCat", nullable = false)
	private Categorie categorie;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "NoRea", nullable = false)
	private Realisateur realisateur;
	@Column(name = "Titre", nullable = false, length = 30)
	private String titre;
	@Column(name = "Duree", nullable = false)
	private int duree;
	@Temporal(TemporalType.DATE)
	@Column(name = "DateSortie", nullable = false, length = 10)
	@XmlJavaTypeAdapter(DateFormater.class)
	private Date dateSortie;
	@Column(name = "Budget", nullable = false)
	private int budget;
	@Column(name = "MontantRecette", nullable = false)
	private int montantRecette;
	@XmlTransient
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "film", orphanRemoval = true, cascade = CascadeType.ALL)
	private Set<Personnage> personnages = new HashSet<Personnage>(0);

	public Film() {
	}

	public Film(int noFilm, Categorie categorie, Realisateur realisateur, String titre, int duree, Date dateSortie,
			int budget, int montantRecette) {
		this.noFilm = noFilm;
		this.categorie = categorie;
		this.realisateur = realisateur;
		this.titre = titre;
		this.duree = duree;
		this.dateSortie = dateSortie;
		this.budget = budget;
		this.montantRecette = montantRecette;
	}

	public Film(int noFilm, Categorie categorie, Realisateur realisateur, String titre, int duree, Date dateSortie,
			int budget, int montantRecette, Set<Personnage> personnages) {
		this.noFilm = noFilm;
		this.categorie = categorie;
		this.realisateur = realisateur;
		this.titre = titre;
		this.duree = duree;
		this.dateSortie = dateSortie;
		this.budget = budget;
		this.montantRecette = montantRecette;
		this.personnages = personnages;
	}

	
	public int getNoFilm() {
		return this.noFilm;
	}

	public void setNoFilm(int noFilm) {
		this.noFilm = noFilm;
	}

	public Categorie getCategorie() {
		return this.categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	
	public Realisateur getRealisateur() {
		return this.realisateur;
	}

	public void setRealisateur(Realisateur realisateur) {
		this.realisateur = realisateur;
	}

	public String getTitre() {
		return this.titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public int getDuree() {
		return this.duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	public Date getDateSortie() {
		return this.dateSortie;
	}

	public void setDateSortie(Date dateSortie) {
		this.dateSortie = dateSortie;
	}

	public int getBudget() {
		return this.budget;
	}

	public void setBudget(int budget) {
		this.budget = budget;
	}

	public int getMontantRecette() {
		return this.montantRecette;
	}

	public void setMontantRecette(int montantRecette) {
		this.montantRecette = montantRecette;
	}

	public Set<Personnage> getPersonnages() {
		return this.personnages;
	}

	public void setPersonnages(Set<Personnage> personnages) {
		this.personnages = personnages;
	}
}
