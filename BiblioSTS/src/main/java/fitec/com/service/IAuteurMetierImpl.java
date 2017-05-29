package fitec.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fitec.com.dao.AuteurRepository;
import fitec.com.entities.Auteur;
import fitec.com.entities.Livre;

@Service
@Transactional
public class IAuteurMetierImpl implements IAuteurMetier {

	@Autowired
	private AuteurRepository daoAuteur;
	
	@Override
	public Auteur add(Auteur object) {
		Auteur a = daoAuteur.save(object);
		return a;
	}

	@Override
	public Auteur find(Integer id) {
		Auteur a = daoAuteur.findOne(id);
		return a;
	}

	@Override
	public Auteur update(Auteur object) {
		Auteur a = daoAuteur.saveAndFlush(object);
		return a;
	}

	@Override
	public void delete(Integer id) {
		
		List<Livre> list = daoAuteur.getAllLivresByAuteurId(id);
		if(list != null || list.size()!=0) {
			System.out.println("Ne peut pas supprimer cet Auteur car au moins un livre y est rattaché");
			throw new RuntimeException("Delete Error : Un livre est lié à cette auteur");
		} else {
			daoAuteur.delete(id);
		}
	}

	@Override
	public List<Livre> listLivres(Integer id_auteur) {
		List<Livre> list = daoAuteur.getAllLivresByAuteurId(id_auteur);
		return list;
	}

	@Override
	public List<Auteur> findAll() {
		List<Auteur> list = daoAuteur.findAll();
		return list;
	}


	
}
