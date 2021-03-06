package main.java.com.epul.metier;
// Generated 25 oct. 2016 08:43:06 by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
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
 * Acteur generated by hbm2java
 */
@Entity
@Table(name = "acteur", catalog = "cinema")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Acteur implements java.io.Serializable {
	private static final long serialVersionUID = 2498857160112461587L;
	
	@Id
	@Column(name = "NoAct", unique = true, nullable = false)
	private int noAct;
	@Column(name = "NomAct", nullable = false, length = 20)
	private String nomAct;
	@Column(name = "PrenAct", length = 20)
	private String prenAct;
	@Temporal(TemporalType.DATE)
	@Column(name = "DateNaiss", length = 10)
	@XmlJavaTypeAdapter(DateFormater.class)
	private Date dateNaiss;
	@Temporal(TemporalType.DATE)
	@Column(name = "DateDeces", length = 10)
	@XmlJavaTypeAdapter(DateFormater.class)
	private Date dateDeces;
	@XmlTransient
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "acteur")
	private Set<Personnage> personnages = new HashSet<Personnage>(0);

	public Acteur() {
	}

	public Acteur(int noAct, String nomAct) {
		this.noAct = noAct;
		this.nomAct = nomAct;
	}

	public Acteur(int noAct, String nomAct, String prenAct, Date dateNaiss, Date dateDeces,
			Set<Personnage> personnages) {
		this.noAct = noAct;
		this.nomAct = nomAct;
		this.prenAct = prenAct;
		this.dateNaiss = dateNaiss;
		this.dateDeces = dateDeces;
		this.personnages = personnages;
	}

	public int getNoAct() {
		return this.noAct;
	}

	public void setNoAct(int noAct) {
		this.noAct = noAct;
	}

	public String getNomAct() {
		return this.nomAct;
	}

	public void setNomAct(String nomAct) {
		this.nomAct = nomAct;
	}

	public String getPrenAct() {
		return this.prenAct;
	}

	public void setPrenAct(String prenAct) {
		this.prenAct = prenAct;
	}

	public Date getDateNaiss() {
		return this.dateNaiss;
	}

	public void setDateNaiss(Date dateNaiss) {
		this.dateNaiss = dateNaiss;
	}

	public Date getDateDeces() {
		return this.dateDeces;
	}

	public void setDateDeces(Date dateDeces) {
		this.dateDeces = dateDeces;
	}

	public Set<Personnage> getPersonnages() {
		return this.personnages;
	}

	public void setPersonnages(Set<Personnage> personnages) {
		this.personnages = personnages;
	}
}
