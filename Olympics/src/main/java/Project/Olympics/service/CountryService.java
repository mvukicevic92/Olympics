package Project.Olympics.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import Project.Olympics.model.Country;

public interface CountryService {
	
	Country findOne(Long id);
	
	List<Country> findAll();
	
	Page<Country> findAll(Pageable pageable);
	
	Country save(Country country);
	
	Country update(Country country);
	
	Country delete(Long id);

}
