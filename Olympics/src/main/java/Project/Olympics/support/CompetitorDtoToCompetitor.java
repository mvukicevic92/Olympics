package Project.Olympics.support;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import Project.Olympics.model.Competitor;
import Project.Olympics.service.CompetitorService;
import Project.Olympics.service.CountryService;
import Project.Olympics.web.dto.CompetitorDTO;

@Component
public class CompetitorDtoToCompetitor implements Converter<CompetitorDTO, Competitor>{
	
	@Autowired
	private CompetitorService competitorService;
	
	@Autowired
	private CountryService countryService;

	@Override
	public Competitor convert(CompetitorDTO dto) {
		Competitor competitor = new Competitor();
		
		if(dto.getId() == null) {
			competitor = new Competitor();
		}else {
			competitor = competitorService.findOne(dto.getId());
		}
		
		if(competitor != null) {
			competitor.setNameAndSurname(dto.getNameAndSurname());
			competitor.setNumOfMedals(dto.getNumOfMedals());;
			competitor.setDateOfBirth(getLocalDate(dto.getDateOfBirth()));
			competitor.setCountry(countryService.findOne(dto.getCountryId()));
		}
		return competitor;
	}
	
    private LocalDate getLocalDate(String date) throws DateTimeParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(date, formatter);
    }

}
