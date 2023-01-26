package Project.Olympics.service;

import java.util.List;

import org.springframework.data.domain.Page;


import Project.Olympics.model.Entry;
import Project.Olympics.web.dto.EntryDTO;

public interface EntryService {
	
	Entry findOne(Long id);
	
	List<Entry> findAll();
	
	Page<Entry> findAll(Integer pageNo);
	
	Entry save(Entry entry);
	
	Entry update(Entry entry);
	
	Entry delete(Long id);
	
	List<Entry> findByCompetitorId(Long competitorId);
	
	Entry createEntry(EntryDTO entryDto);

}
