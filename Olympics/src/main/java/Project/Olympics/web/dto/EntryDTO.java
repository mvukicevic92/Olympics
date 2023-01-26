package Project.Olympics.web.dto;

import javax.validation.constraints.Positive;

public class EntryDTO {
	
	@Positive
	private Long id;
	
	private String dateOfEntry;
	
	private String discipline;
	
	@Positive
	private Long competitorId;
	
	private String nameAndSurnameOfCompetitor;

	public EntryDTO() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDateOfEntry() {
		return dateOfEntry;
	}

	public void setDateOfEntry(String dateOfEntry) {
		this.dateOfEntry = dateOfEntry;
	}

	public String getDiscipline() {
		return discipline;
	}

	public void setDiscipline(String discipline) {
		this.discipline = discipline;
	}

	public Long getCompetitorId() {
		return competitorId;
	}

	public void setCompetitorId(Long competitorId) {
		this.competitorId = competitorId;
	}

	public String getNameAndSurnameOfCompetitor() {
		return nameAndSurnameOfCompetitor;
	}

	public void setNameAndSurnameOfCompetitor(String nameAndSurnameOfCompetitor) {
		this.nameAndSurnameOfCompetitor = nameAndSurnameOfCompetitor;
	}
	
	

}
