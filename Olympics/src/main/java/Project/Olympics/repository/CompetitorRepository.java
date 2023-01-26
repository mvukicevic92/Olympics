package Project.Olympics.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Project.Olympics.model.Competitor;

@Repository
public interface CompetitorRepository extends JpaRepository<Competitor, Long>{
	
	Competitor findOneById(Long id);
	
	List<Competitor> findByCountryId(Long countryId);
	
	Page<Competitor> findByNumOfMedalsBetween(Integer numOfMedalsFrom, Integer numOfMedalsTo, Pageable pageable);
	
	Page<Competitor> findByNumOfMedalsBetweenAndCountryId(Integer numOfMedalsFrom, Integer numOfMedalsTo, Long countryId, Pageable pageable);

}
