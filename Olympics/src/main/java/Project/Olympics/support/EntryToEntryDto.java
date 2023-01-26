package Project.Olympics.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import Project.Olympics.model.Entry;
import Project.Olympics.web.dto.EntryDTO;

@Component
public class EntryToEntryDto implements Converter<Entry, EntryDTO>{

	@Override
	public EntryDTO convert(Entry entry) {
		EntryDTO dto = new EntryDTO();
		dto.setId(entry.getId());
		dto.setDateOfEntry(entry.getDateOfEntry().toString());
		dto.setDiscipline(entry.getDiscipline());
		dto.setCompetitorId(entry.getCompetitor().getId());
		dto.setNameAndSurnameOfCompetitor(entry.getCompetitor().getNameAndSurname());
		return dto;
	}
	
	public List<EntryDTO> convert(List<Entry> entries){
		List<EntryDTO> entriesDto = new ArrayList<>();
		
		for(Entry entry : entries) {
			entriesDto.add(convert(entry));
		}
		return entriesDto;
	}

}
