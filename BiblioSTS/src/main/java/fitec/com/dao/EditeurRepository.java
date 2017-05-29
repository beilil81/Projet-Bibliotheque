package fitec.com.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fitec.com.entities.Editeur;
import fitec.com.entities.Livre;

public interface EditeurRepository extends JpaRepository<Editeur, Integer>{
	
	@Query("select l from Livre l where l.editeur.id =:x")
	public List<Livre> getAllLivresByEditeurId(@Param("x") Integer editeurId);
 
}
