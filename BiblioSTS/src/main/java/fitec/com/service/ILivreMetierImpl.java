package fitec.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fitec.com.dao.LivreRepository;
import fitec.com.entities.Livre;

@Service
@Transactional
public class ILivreMetierImpl implements ILivreMetier {

	@Autowired
	private LivreRepository daoLivre;
	
	@Override
	public Livre add(Livre object) {
		Livre l = daoLivre.save(object);
		return l;
	}

	@Override
	public Livre find(Integer id) {
		Livre l = daoLivre.findOne(id);
		return l;
	}

	@Override
	public Livre update(Livre object) {
		Livre l = daoLivre.saveAndFlush(object);
		return l;
	}

	@Override
	public void delete(Integer id) {
		daoLivre.delete(id);
	}

	@Override
	public List<Livre> findAll() {
		List<Livre> list = daoLivre.findAll();
		return list;
	}




	
}
