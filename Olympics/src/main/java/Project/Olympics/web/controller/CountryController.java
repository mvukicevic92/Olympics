package Project.Olympics.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Project.Olympics.model.Country;
import Project.Olympics.service.CountryService;
import Project.Olympics.support.CountryToCountryDto;
import Project.Olympics.web.dto.CountryDTO;

@RestController
@RequestMapping(value = "/api/countries", produces = MediaType.APPLICATION_JSON_VALUE)
public class CountryController {
	
	@Autowired
	private CountryService countryService;
	
	@Autowired
	private CountryToCountryDto toCountryDto;
	
	@GetMapping
	public ResponseEntity<List<CountryDTO>> getAll(){
		List<Country> countries = countryService.findAll();
		if(countries != null) {
			return new ResponseEntity<>(toCountryDto.convert(countries), HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
