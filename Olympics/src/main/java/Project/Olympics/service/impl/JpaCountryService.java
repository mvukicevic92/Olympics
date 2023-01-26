package Project.Olympics.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import Project.Olympics.model.Country;
import Project.Olympics.repository.CountryRepository;
import Project.Olympics.service.CountryService;

@Service
public class JpaCountryService implements CountryService{
	
	@Autowired
	private CountryRepository countryRepository;
	
	@Override
	public Country findOne(Long id) {
		return countryRepository.findOneById(id);
	}

	@Override
	public List<Country> findAll() {
		return countryRepository.findAll();
	}

	@Override
	public Page<Country> findAll(Pageable pageable) {
		return countryRepository.findAll(pageable);
	}

	@Override
	public Country save(Country country) {
		return countryRepository.save(country);
	}

	@Override
	public Country update(Country country) {
		return countryRepository.save(country);
	}

	@Override
	public Country delete(Long id) {
		Optional<Country> country = countryRepository.findById(id);
		if(country.isPresent()) {
			countryRepository.deleteById(id);
			return country.get();
		}
		return null;
	}
	
	

}
