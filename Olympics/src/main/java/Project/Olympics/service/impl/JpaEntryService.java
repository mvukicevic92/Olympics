package Project.Olympics.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import Project.Olympics.model.Entry;
import Project.Olympics.repository.EntryRepository;
import Project.Olympics.service.EntryService;
import Project.Olympics.support.EntryDtoToEntry;
import Project.Olympics.web.dto.EntryDTO;

@Service
public class JpaEntryService implements EntryService{
	
	@Autowired
	private EntryRepository entryRepository;
	
	@Autowired
	private EntryDtoToEntry toEntry;

	@Override
	public Entry findOne(Long id) {
		// TODO Auto-generated method stub
		return entryRepository.findOneById(id);
	}

	@Override
	public List<Entry> findAll() {
		// TODO Auto-generated method stub
		return entryRepository.findAll();
	}

	@Override
	public Page<Entry> findAll(Integer pageNo) {
		// TODO Auto-generated method stub
		return entryRepository.findAll(PageRequest.of(pageNo, 5));
	}

	@Override
	public Entry save(Entry entry) {
		// TODO Auto-generated method stub
		return entryRepository.save(entry);
	}

	@Override
	public Entry update(Entry entry) {
		// TODO Auto-generated method stub
		return entryRepository.save(entry);
	}

	@Override
	public Entry delete(Long id) {
		Optional<Entry> entry = entryRepository.findById(id);
		if(entry.isPresent()) {
			entryRepository.deleteById(id);
			return entry.get();
		}
		return null;
	}

	@Override
	public List<Entry> findByCompetitorId(Long competitorId) {
		// TODO Auto-generated method stub
		return entryRepository.findByCompetitorId(competitorId);
	}

	@Override
	public Entry createEntry(EntryDTO entryDto) {
		entryDto.setDateOfEntry(LocalDate.now().toString());
		Entry entry = toEntry.convert(entryDto);
		entry.setDateOfEntry(LocalDate.now());
		return entryRepository.save(entry);
	}

}
