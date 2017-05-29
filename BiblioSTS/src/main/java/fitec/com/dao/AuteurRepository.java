package fitec.com.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fitec.com.entities.Auteur;
import fitec.com.entities.Livre;

public interface AuteurRepository extends JpaRepository <Auteur, Integer>{

	
	@Query("select l from Livre l where l.auteur.id =:x")
	public List<Livre> getAllLivresByAuteurId(@Param("x") Integer auteurId);
	
	
}
