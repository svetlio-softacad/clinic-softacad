package entity;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "DOCTORS")
@PrimaryKeyJoinColumn(name = "ID")
public class Doctor extends Person {
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name = "TITLE_ID")
	private Title title;
	
	@OneToMany(mappedBy = "doctor")
	private List<Visit> visits;
	
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE },targetEntity = Specialty.class)
	@JoinTable(name = "DOCTORS_SPECIALTIES",joinColumns = @JoinColumn(name = "DOCTOR_ID"),inverseJoinColumns = @JoinColumn(name = "SPECIALTY_ID"))
	private Set<Specialty> specialties;
	
	public Title getTitle() {
		return title;
	}
	public void setTitle(Title title) {
		this.title = title;
	}
}
