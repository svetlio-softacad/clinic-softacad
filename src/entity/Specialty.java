package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "SPECIALTIES")
public class Specialty implements Persistable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SPECIALTIES_SEQ_GEN")
	@SequenceGenerator(name = "SPECIALTIES_SEQ_GEN", sequenceName = "SPECIALTIES_SEQ")
	@Column(name = "ID")
	private long id;
	
	@Column(name = "NAME", nullable = false, length = 20)
	private String name;

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	

}
