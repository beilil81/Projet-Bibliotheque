package fitec.com.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fitec.com.entities.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
