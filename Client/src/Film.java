import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Film implements java.io.Serializable {
	private static final long serialVersionUID = -4158730546766376186L;
	
	private int noFilm;
	private Categorie categorie;
	private Realisateur realisateur;
	private String titre;
	private int duree;
	//@XmlJavaTypeAdapter(DateFormater.class)
	private Date dateSortie;
	private int budget;
	private int montantRecette;

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
}
