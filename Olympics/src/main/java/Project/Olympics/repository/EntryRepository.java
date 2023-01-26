package Project.Olympics.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Project.Olympics.model.Entry;

@Repository
public interface EntryRepository extends JpaRepository<Entry, Long>{
	
	Entry findOneById(Long id);
	
	List<Entry> findByCompetitorId(Long competitorId);

}
