// default package
// Generated 10 oct. 2016 11:51:27 by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Film generated by hbm2java
 */
public class Film implements java.io.Serializable {

	private int noFilm;
	private Categorie categorie;
	private Realisateur realisateur;
	private String titre;
	private int duree;
	private Date dateSortie;
	private int budget;
	private int montantRecette;
	private Set personnages = new HashSet(0);

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
			int budget, int montantRecette, Set personnages) {
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

	public Set getPersonnages() {
		return this.personnages;
	}

	public void setPersonnages(Set personnages) {
		this.personnages = personnages;
	}

}
