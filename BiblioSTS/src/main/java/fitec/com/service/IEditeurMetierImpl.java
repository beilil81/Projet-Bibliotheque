package fitec.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fitec.com.dao.EditeurRepository;
import fitec.com.entities.Editeur;
import fitec.com.entities.Livre;

@Service
@Transactional
public class IEditeurMetierImpl implements IEditeurMetier {

	@Autowired
	private EditeurRepository daoEditeur;
	
	@Override
	public Editeur add(Editeur object) {
		Editeur e = daoEditeur.save(object);
		return e;
	}

	@Override
	public Editeur find(Integer id) {
		Editeur e = daoEditeur.findOne(id);
		return e;
	}

	@Override
	public Editeur update(Editeur object) {
		Editeur e = daoEditeur.saveAndFlush(object);
		return e;
	}

	@Override
	public void delete(Integer id) {
		
		System.out.println("TEST DELETE Ed 1");
		List<Livre> list = daoEditeur.getAllLivresByEditeurId(id);
		System.out.println("TEST XXXXXXXXXXXX : " + list);
		if(list != null || list.size()!=0) {
			System.out.println("Ne peut pas supprimer cet Editeur car au moins un livre y est rattaché");
			throw new RuntimeException("Delete Error : Un livre est lié à cette éditeur");
		} else {
			System.out.println("ICI TESTE");
			daoEditeur.delete(id);
		}
	}

	@Override
	public List<Livre> listLivres(Integer id_editeur) {
		List<Livre> list = daoEditeur.getAllLivresByEditeurId(id_editeur);
		return list;
	}

	@Override
	public List<Editeur> findAll() {
		List<Editeur> list = daoEditeur.findAll();
		return list;
	}


	
}
