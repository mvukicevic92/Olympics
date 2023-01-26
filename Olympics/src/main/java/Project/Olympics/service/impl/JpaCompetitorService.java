package Project.Olympics.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import Project.Olympics.model.Competitor;
import Project.Olympics.repository.CompetitorRepository;
import Project.Olympics.service.CompetitorService;

@Service
public class JpaCompetitorService implements CompetitorService{
	
	@Autowired
	private CompetitorRepository competitorRepository;

	@Override
	public Competitor findOne(Long id) {
		return competitorRepository.findOneById(id);
	}

	@Override
	public List<Competitor> findAll() {
		return competitorRepository.findAll();
	}

	@Override
	public Page<Competitor> findAll(Integer pageNo) {
		return competitorRepository.findAll(PageRequest.of(pageNo, 5));
	}

	@Override
	public Competitor save(Competitor competitor) {
		return competitorRepository.save(competitor);
	}

	@Override
	public Competitor update(Competitor competitor) {
		return competitorRepository.save(competitor);
	}

	@Override
	public Competitor delete(Long id) {
		Competitor competitor = competitorRepository.findOneById(id);
		if(competitor != null) {
			competitor.getCountry().getCompetitors().remove(competitor);
			competitorRepository.delete(competitor);
			return competitor;
		}
		return null;
	}

	@Override
	public List<Competitor> findByCountryId(Long countryId) {
		return competitorRepository.findByCountryId(countryId);
	}

	@Override
	public Page<Competitor> find(Integer numOfMedalsFrom, Integer numOfMedalsTo, Long countryId, Integer pageNo) {
		if(numOfMedalsFrom == null) {
			numOfMedalsFrom = 0;
		}
		if(numOfMedalsTo == null) {
			numOfMedalsTo = Integer.MAX_VALUE;
		}
		if(countryId == null) {
			return competitorRepository.findByNumOfMedalsBetween(numOfMedalsFrom, numOfMedalsTo, PageRequest.of(pageNo, 5));
		}
		return competitorRepository.findByNumOfMedalsBetweenAndCountryId(numOfMedalsFrom, numOfMedalsTo, countryId, PageRequest.of(pageNo, 5));
	}

}
