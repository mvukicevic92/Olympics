package Project.Olympics.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import Project.Olympics.model.Competitor;
import Project.Olympics.web.dto.CompetitorDTO;

@Component
public class CompetitorToCompetitorDto implements Converter<Competitor, CompetitorDTO>{

	@Override
	public CompetitorDTO convert(Competitor competitor) {
		CompetitorDTO dto = new CompetitorDTO();
		dto.setId(competitor.getId());
		dto.setNameAndSurname(competitor.getNameAndSurname());
		dto.setNumOfMedals(competitor.getNumOfMedals());
		dto.setDateOfBirth(competitor.getDateOfBirth().toString());
		dto.setCountryId(competitor.getCountry().getId());
		dto.setNameOfCountry(competitor.getCountry().getName());
		return dto;
	}
	
	public List<CompetitorDTO> convert(List<Competitor> competitors){
		List<CompetitorDTO> competitorsDto = new ArrayList<>();
		
		for(Competitor competitor: competitors) {
			competitorsDto.add(convert(competitor));
		}
		return competitorsDto;
	}

}
