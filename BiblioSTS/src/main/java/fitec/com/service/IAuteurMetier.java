package fitec.com.service;

import java.util.List;

import fitec.com.entities.Auteur;
import fitec.com.entities.Livre;

public interface IAuteurMetier extends IMetier<Auteur> {
	
	public List<Livre> listLivres(Integer id_auteur);

}
