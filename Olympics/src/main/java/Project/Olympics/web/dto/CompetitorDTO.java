package Project.Olympics.web.dto;

import javax.validation.constraints.Positive;

import org.hibernate.validator.constraints.Length;

public class CompetitorDTO {
	
	@Positive
	private Long id;
	
	@Length(max = 60)
	private String nameAndSurname;
	
	@Positive
	private Integer numOfMedals;
	
	private String dateOfBirth;
	
	@Positive
	private Long countryId;
	
	private String nameOfCountry;

	public CompetitorDTO() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNameAndSurname() {
		return nameAndSurname;
	}

	public void setNameAndSurname(String nameAndSurname) {
		this.nameAndSurname = nameAndSurname;
	}

	public Integer getNumOfMedals() {
		return numOfMedals;
	}

	public void setNumOfMedals(Integer numOfMedals) {
		this.numOfMedals = numOfMedals;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Long getCountryId() {
		return countryId;
	}

	public void setCountryId(Long countryId) {
		this.countryId = countryId;
	}

	public String getNameOfCountry() {
		return nameOfCountry;
	}

	public void setNameOfCountry(String nameOfCountry) {
		this.nameOfCountry = nameOfCountry;
	}
	
	
}
