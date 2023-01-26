package Project.Olympics.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import Project.Olympics.model.Country;
import Project.Olympics.web.dto.CountryDTO;

@Component
public class CountryToCountryDto implements Converter<Country, CountryDTO>{

	@Override
	public CountryDTO convert(Country country) {
		CountryDTO dto = new CountryDTO();
		dto.setId(country.getId());
		dto.setName(country.getName());
		dto.setMark(country.getMark());
		return dto;
	}
	
	public List<CountryDTO> convert(List<Country> countries){
		List<CountryDTO> countriesDto = new ArrayList<>();
		
		for(Country country: countries) {
			countriesDto.add(convert(country));
		}
		return countriesDto;
	}
	

}
