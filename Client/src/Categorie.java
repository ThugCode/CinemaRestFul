import java.util.HashSet;
import java.util.Set;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Categorie implements java.io.Serializable {
	private static final long serialVersionUID = -64893359793689852L;
	
	private String codeCat;
	private String libelleCat;
	@XmlTransient
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
