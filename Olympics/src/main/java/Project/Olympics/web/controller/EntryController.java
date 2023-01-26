package Project.Olympics.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Project.Olympics.model.Entry;
import Project.Olympics.service.EntryService;
import Project.Olympics.support.EntryToEntryDto;
import Project.Olympics.web.dto.EntryDTO;

@RestController
@RequestMapping(value = "api/entries", produces = MediaType.APPLICATION_JSON_VALUE)
public class EntryController {
	
	@Autowired
	private EntryService entryService;
	
	@Autowired
	private EntryToEntryDto toEntryDto;
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EntryDTO> create(@Valid @RequestBody EntryDTO entryDto){
		Entry entry = entryService.createEntry(entryDto);
		
		return new ResponseEntity<>(toEntryDto.convert(entry), HttpStatus.OK);
	}

}
