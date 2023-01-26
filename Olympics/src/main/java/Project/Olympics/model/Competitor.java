package Project.Olympics.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Competitor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String nameAndSurname;
	
	@Column
	private int numOfMedals;
	
	@Column(nullable = false)
	private LocalDate dateOfBirth;
	
	@ManyToOne
	private Country country;
	
	@OneToMany(mappedBy = "competitor", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<Entry> entries = new HashSet<>();

	public Competitor() {
		super();
	}

	public Competitor(String nameAndSurname, int numOfMedals, LocalDate dateOfBirth, Country country) {
		super();
		this.nameAndSurname = nameAndSurname;
		this.numOfMedals = numOfMedals;
		this.dateOfBirth = dateOfBirth;
		this.country = country;
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

	public int getNumOfMedals() {
		return numOfMedals;
	}

	public void setNumOfMedals(int numOfMedals) {
		this.numOfMedals = numOfMedals;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
		if(country != null && !country.getCompetitors().contains(this)) {
			country.getCompetitors().add(this);
		}
	}

	public Set<Entry> getEntries() {
		return entries;
	}

	public void setEntries(Set<Entry> entries) {
		this.entries = entries;
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
		Competitor other = (Competitor) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Competitor [id=" + id + ", nameAndSurname=" + nameAndSurname + ", numOfMedals=" + numOfMedals
				+ ", dateOfBirth=" + dateOfBirth + ", country=" + country.getName() + "]";
	}
	
	
	
}
