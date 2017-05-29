package fitec.com.service;

import java.util.List;

import fitec.com.entities.Editeur;
import fitec.com.entities.Livre;

public interface IEditeurMetier extends IMetier<Editeur>{

	public List<Livre> listLivres(Integer id_editeur);
	
}
