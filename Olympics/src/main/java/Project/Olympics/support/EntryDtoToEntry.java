package Project.Olympics.support;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import Project.Olympics.model.Entry;
import Project.Olympics.service.CompetitorService;
import Project.Olympics.service.EntryService;
import Project.Olympics.web.dto.EntryDTO;

@Component
public class EntryDtoToEntry implements Converter<EntryDTO, Entry>{

	@Autowired
	private EntryService entryService;
	
	@Autowired
	private CompetitorService competitorService;

	@Override
	public Entry convert(EntryDTO dto) {
		Entry entry = new Entry();
		if(dto.getId() == null) {
			entry = new Entry();
		}else {
			entry = entryService.findOne(dto.getId());
		}
		
		if(entry != null) {
			entry.setDateOfEntry(getLocalDate(dto.getDateOfEntry()));
			entry.setDiscipline(dto.getDiscipline());
			entry.setCompetitor(competitorService.findOne(dto.getCompetitorId()));
		}
		
		return null;
	}
	
	private LocalDate getLocalDate(String date) throws DateTimeParseException{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		return LocalDate.parse(date, formatter);
	}
	
}
