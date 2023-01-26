package Project.Olympics.service;

import java.util.List;

import org.springframework.data.domain.Page;


import Project.Olympics.model.Competitor;

public interface CompetitorService {
	
	Competitor findOne(Long id);
	
	List<Competitor> findAll();
	
	Page<Competitor> findAll(Integer pageNo);
	
	Competitor save(Competitor competitor);
	
	Competitor update(Competitor competitor);
	
	Competitor delete(Long id);
	
	List<Competitor> findByCountryId(Long countryId);
	
	Page<Competitor> find(Integer numOfMedalsFrom, Integer numOfMedalsTo, Long countryId, Integer pageNo);

}
