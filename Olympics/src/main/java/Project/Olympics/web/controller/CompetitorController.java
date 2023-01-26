package Project.Olympics.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Project.Olympics.model.Competitor;
import Project.Olympics.model.Country;
import Project.Olympics.service.CompetitorService;
import Project.Olympics.support.CompetitorDtoToCompetitor;
import Project.Olympics.support.CompetitorToCompetitorDto;
import Project.Olympics.web.dto.CompetitorDTO;

@RestController
@RequestMapping(value = "/api/competitors", produces = MediaType.APPLICATION_JSON_VALUE)
public class CompetitorController {
	
	@Autowired
	private CompetitorService competitorService;
	
	@Autowired
	private CompetitorToCompetitorDto toCompetitorDto;
	
	@Autowired
	private CompetitorDtoToCompetitor toCompetitor;
	
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CompetitorDTO> create(@Valid @RequestBody CompetitorDTO competitorDto){
		Competitor competitor = toCompetitor.convert(competitorDto);
		if(competitor.getCountry() == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Competitor savedCompetitor = competitorService.save(competitor);
		return new ResponseEntity<>(toCompetitorDto.convert(savedCompetitor), HttpStatus.OK);
	}
	
	@PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CompetitorDTO> update (@PathVariable Long id, @Valid @RequestBody CompetitorDTO competitorDto){
		if(!id.equals(competitorDto.getId())) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Competitor competitor = toCompetitor.convert(competitorDto);
		if(competitor.getCountry() == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Competitor savedCompetitor = competitorService.update(competitor);
		return new ResponseEntity<>(toCompetitorDto.convert(savedCompetitor), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<CompetitorDTO> delete (@PathVariable Long id){
		Competitor deletedCompetitor = competitorService.delete(id);
		if(deletedCompetitor == null) {
			return new ResponseEntity<>(toCompetitorDto.convert(deletedCompetitor), HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<CompetitorDTO> getOne(@PathVariable Long id){
		Competitor competitor = competitorService.findOne(id);
		if(competitor != null) {
			return new ResponseEntity<>(toCompetitorDto.convert(competitor), HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping
	public ResponseEntity<List<CompetitorDTO>> getAll(@RequestParam(required = false) Long countryId,
													  @RequestParam(required = false) Integer numOfMedalsFrom,
													  @RequestParam(required = false) Integer numOfMedalsTo,
													  @RequestParam(value = "pageNo", defaultValue = "0") int pageNo){
		Page<Competitor> page;
		try {
			page = competitorService.find(numOfMedalsFrom, numOfMedalsTo, countryId, pageNo);
		}catch(Exception e) {
			page = competitorService.findAll(pageNo);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.add("Total-Pages", Integer.toString(page.getTotalPages()));
		
		return new ResponseEntity<>(toCompetitorDto.convert(page.getContent()), headers, HttpStatus.OK);
	}
	
	@GetMapping(value = "/statistic")
	public ResponseEntity<Map<String, Integer>> getStatistic(){
		List<Competitor> competitors = competitorService.findAll();
		String nameOfCountry;
		Integer numOfMedals = 0;
		Map<String, Integer> statistic = new HashMap<>();
		for(Competitor competitor : competitors) {
			Country country = competitor.getCountry();
			nameOfCountry = country.getName();
			for(int i = 0; i < competitors.size(); i++) {
				numOfMedals += competitor.getNumOfMedals();
				statistic.put(nameOfCountry, numOfMedals);
			}
			
		}
		
//		double suma = 0.0;
//		for (int i = 0; i < this.lista.size(); i++) {
//			suma += this.lista.get(i).getIznos();
//		}
		
//		Integer totalMedals = 0;
//		List<Country> countries = countryService.findAll();
//		for(Country country: countries) {
//			nameOfCountry = country.getName();
//			for(Competitor competitor : country.getCompetitors()) {
//				numOfMedals = competitor.getNumOfMedals();
//				totalMedals++;
//				statistic.put(nameOfCountry, totalMedals);
//			}
//			
//		}
		return new ResponseEntity<>(statistic, HttpStatus.OK);
	}

}
