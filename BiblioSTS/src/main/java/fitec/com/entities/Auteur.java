/*******************************************************************************
 * 2017, All rights reserved.
 *******************************************************************************/
package fitec.com.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

// Start of user code (user defined imports)

// End of user code

/**
 * Description of Auteur.
 * 
 * @author Developpeur
 */
@Entity
@Table(name="auteur")
public class Auteur implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6431746195226795801L;

	/**
	 * Description of the property id.
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	/**
	 * Description of the property nom.
	 */
	private String nom = "";

	/**
	 * Description of the property prenom.
	 */
	private String prenom = "";

	@OneToMany(mappedBy="auteur")
	private List<Livre> livres;


	public List<Livre> getLivres() {
		return livres;
	}

	public void setLivres(List<Livre> livres) {
		this.livres = livres;
	}

	/**
	 * The constructor.
	 */
	public Auteur() {
		super();
	
	}

	public Auteur(Integer id, String nom, String prenom) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
	}

	// Start of user code (user defined methods for Auteur)

	// End of user code
	/**
	 * Returns id.
	 * @return id 
	 */
	public Integer getId() {
		return this.id;
	}

	/**
	 * Sets a value to attribute id. 
	 * @param newId 
	 */
	public void setId(Integer newId) {
		this.id = newId;
	}

	/**
	 * Returns nom.
	 * @return nom 
	 */
	public String getNom() {
		return this.nom;
	}

	/**
	 * Sets a value to attribute nom. 
	 * @param newNom 
	 */
	public void setNom(String newNom) {
		this.nom = newNom;
	}

	/**
	 * Returns prenom.
	 * @return prenom 
	 */
	public String getPrenom() {
		return this.prenom;
	}

	/**
	 * Sets a value to attribute prenom. 
	 * @param newPrenom 
	 */
	public void setPrenom(String newPrenom) {
		this.prenom = newPrenom;
	}

	@Override
	public String toString() {
		return "Auteur [id=" + id + ", nom=" + nom + ", prenom=" + prenom + "]";
	}
}
