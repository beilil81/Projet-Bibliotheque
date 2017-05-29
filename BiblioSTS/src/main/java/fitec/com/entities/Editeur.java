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

/**
 * Description of Editeur.
 * 
 * @author Developpeur
 */
@Entity
@Table(name="editeur")
public class Editeur implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1583693605369206809L;

	/**
	 * Description of the property id.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	/**
	 * Description of the property nom.
	 */
	private String nom;

	@OneToMany(mappedBy="editeur")
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
	public Editeur() {
		super();

	}

	public Editeur(Editeur e) {
		this(e.getId(), e.getNom());
	}

	public Editeur(Integer id, String nom) {
		this.id = id;
		this.nom = nom;
	}

	/**
	 * Returns id.
	 * 
	 * @return id
	 */
	public Integer getId() {
		return this.id;
	}

	/**
	 * Sets a value to attribute id.
	 * 
	 * @param newId
	 */
	public void setId(Integer newId) {
		this.id = newId;
	}

	/**
	 * Returns nom.
	 * 
	 * @return nom
	 */
	public String getNom() {
		return this.nom;
	}

	/**
	 * Sets a value to attribute nom.
	 * 
	 * @param newNom
	 */
	public void setNom(String newNom) {
		this.nom = newNom;
	}

	@Override
	public String toString() {
		return "Editeur [id=" + id + ", nom=" + nom + "]";
	}
}
