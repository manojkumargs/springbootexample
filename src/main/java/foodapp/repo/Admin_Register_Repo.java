package foodapp.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import foodapp.model.Admin_Register;

@EnableJpaRepositories
@Repository
public interface Admin_Register_Repo extends JpaRepository<Admin_Register,Integer>
{
      Optional<Admin_Register> findOneByEmailAndPassword(String email, String password);
      Admin_Register findByEmail(String email);
	
}
