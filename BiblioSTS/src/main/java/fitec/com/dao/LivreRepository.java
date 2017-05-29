package fitec.com.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fitec.com.entities.Livre;

public interface LivreRepository extends JpaRepository<Livre, Integer> {

}
