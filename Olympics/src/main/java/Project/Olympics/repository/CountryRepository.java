package Project.Olympics.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Project.Olympics.model.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long>{
	
	Country findOneById(Long id);

}
