package Project.Olympics.web.dto;

import javax.validation.constraints.Positive;

import org.hibernate.validator.constraints.Length;

public class CountryDTO {
	
	@Positive
	private Long id;
	
	private String name;
	
	@Length(max = 3)
	private String mark;

	public CountryDTO() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}
	
	

}
