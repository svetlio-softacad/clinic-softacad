package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "PERSONS")
@Inheritance(strategy = InheritanceType.JOINED)
public class Person implements Persistable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PERSONS_SEQ_GEN")
	@SequenceGenerator(name = "PERSONS_SEQ_GEN", sequenceName = "PERSONS_SEQ")
	@Column(name = "ID")
	protected long id;
	
	@Column(name = "FIRST_NAME", nullable = false, length = 50)
	protected String firstName;
	
	@Column(name = "LAST_NAME", nullable = false, length = 50)
	protected String lastName;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
}
