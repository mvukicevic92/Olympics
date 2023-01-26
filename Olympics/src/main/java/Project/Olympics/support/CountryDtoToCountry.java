package Project.Olympics.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import Project.Olympics.model.Country;
import Project.Olympics.service.CountryService;
import Project.Olympics.web.dto.CountryDTO;

@Component
public class CountryDtoToCountry implements Converter<CountryDTO, Country>{
	
	@Autowired
	private CountryService countryService;

	@Override
	public Country convert(CountryDTO dto) {
		Country country = new Country();
		
		if(dto.getId() == null) {
			country = new Country();
		}else {
			country = countryService.findOne(dto.getId());
		}
		
		if(country != null) {
			country.setName(dto.getName());
			country.setMark(dto.getMark());
		}
		return country;
	}

}
