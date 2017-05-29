/*******************************************************************************
 * 2017, All rights reserved.
 *******************************************************************************/
package fitec.com.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

// End of user code

/**
 * Description of Livre.
 * 
 * @author Developpeur
 */
@Entity
@Table(name="livre")
public class Livre implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2839187564837878273L;

	/**
	 * Description of the property id.
	 */
	@Id
	@GeneratedValue
	private Integer id;

	/**
	 * Description of the property titre.
	 */
	private String titre;

	/**
	 * Description of the property auteur.
	 */
	@ManyToOne
	@JoinColumn(name="id_auteur")
	private Auteur auteur;

	/**
	 * Description of the property editeur.
	 */
	@ManyToOne
	@JoinColumn(name="id_editeur")
	private Editeur editeur;

	/**
	 * Description of the property nbpages.
	 */
	private int nb_pages = 0;

	private Float prix;

	// Start of user code (user defined attributes for Livre)

	// End of user code

	/**
	 * The constructor.
	 */
	public Livre() {
		// Start of user code constructor for Livre)
		super();
		// End of user code
	}

	public Livre(Integer id, String titre, Auteur auteur, Editeur editeur, int nbpages, Float prix) {
		this.id = id;
		this.titre = titre;
		this.auteur = auteur;
		this.editeur = editeur;
		this.nb_pages = nbpages;
		this.prix = prix;
	}

	// Start of user code (user defined methods for Livre)

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
	 * Returns titre.
	 * @return titre 
	 */
	public String getTitre() {
		return this.titre;
	}

	/**
	 * Sets a value to attribute titre. 
	 * @param newTitre 
	 */
	public void setTitre(String newTitre) {
		this.titre = newTitre;
	}

	/**
	 * Returns auteur.
	 * @return auteur 
	 */
	public Auteur getAuteur() {
		return this.auteur;
	}

	/**
	 * Sets a value to attribute auteur. 
	 * @param newAuteur 
	 */
	public void setAuteur(Auteur newAuteur) {
		this.auteur = newAuteur;
	}

	/**
	 * Returns editeur.
	 * @return editeur 
	 */
	public Editeur getEditeur() {
		return this.editeur;
	}

	/**
	 * Sets a value to attribute editeur. 
	 * @param newEditeur 
	 */
	public void setEditeur(Editeur newEditeur) {
		this.editeur = newEditeur;
	}

	/**
	 * Returns nbpages.
	 * @return nbpages 
	 */
	public int getNbPages() {
		return this.nb_pages;
	}

	/**
	 * Sets a value to attribute nbpages. 
	 * @param newNbpages 
	 */
	public void setNbPages(int newNbPages) {
		this.nb_pages = newNbPages;
	}

	public Float getPrix() {
		return prix;
	}

	public void setPrix(Float prix) {
		this.prix = prix;
	}

	public Integer getIdAuteur() {
		return this.auteur.getId();
	}

	public Integer getIdEditeur() {
		return this.editeur.getId();
	}

	public String getNomAuteur() {
		return this.auteur.getNom();
	}

	public String getPreNomAuteur() {
		return this.auteur.getPrenom();
	}

	public String getNomEditeur() {
		return this.editeur.getNom();
	}
	
	@Override
	public String toString() {
		return "Livres [id=" + id + ", titre=" + titre + ", id_auteur=" + auteur.getId() + ", id_editeur=" + editeur.getId() + "]";
	}
}
