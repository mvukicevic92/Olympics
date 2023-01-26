package Project.Olympics.model;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Entry {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private LocalDate dateOfEntry;
	
	@Column
	private String discipline;
	
	@ManyToOne
	private Competitor competitor;

	public Entry() {
		super();
	}

	public Entry(LocalDate dateOfEntry, String discipline, Competitor competitor) {
		super();
		this.dateOfEntry = dateOfEntry;
		this.discipline = discipline;
		this.competitor = competitor;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDateOfEntry() {
		return dateOfEntry;
	}

	public void setDateOfEntry(LocalDate dateOfEntry) {
		this.dateOfEntry = dateOfEntry;
	}

	public String getDiscipline() {
		return discipline;
	}

	public void setDiscipline(String discipline) {
		this.discipline = discipline;
	}

	public Competitor getCompetitor() {
		return competitor;
	}

	public void setCompetitor(Competitor competitor) {
		this.competitor = competitor;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Entry other = (Entry) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Entry [id=" + id + ", dateOfEntry=" + dateOfEntry + ", discipline=" + discipline + ", competitor="
				+ competitor.getNameAndSurname() + "]";
	}
	
	
}
