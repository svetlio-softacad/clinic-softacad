package entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "PATIENTS")
@PrimaryKeyJoinColumn(name = "ID")
public class Patient extends Person {
	
	@Column(name = "AGE", nullable = false)
	private int age;
	
	@Column(name = "EGN", nullable = false, length = 25)
	private String egn;
	
	@OneToMany(mappedBy = "patient")
	private List<Visit> visits;
	
	public List<Visit> getVisits() {
		return visits;
	}

	public void setVisits(List<Visit> visits) {
		this.visits = visits;
	}

	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getEgn() {
		return egn;
	}
	
	public void setEgn(String egn) {
		this.egn = egn;
	}
	
	

}
