package entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.SequenceGenerator;

@Entity
@Table(name = "VISITS")
public class Visit implements Persistable {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "VISITS_SEQ_GEN")
	@SequenceGenerator(name = "VISITS_SEQ_GEN", sequenceName = "VISITS_SEQ")
	@Column(name = "ID")
	private long id;
		
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name = "PATIENT_ID")
	private Patient patient;
	
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name = "DOCTOR_ID")
	private Doctor doctor;
	
	@Column(name = "DATE_OF_VISIT", nullable = false)
	private Date date;
	
	@Column(name = "DIAGNOSE", nullable = false, length = 50)
	private String diagnose;
	
	@Column(name = "PRICE", nullable = false)
	private double price;
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getDiagnose() {
		return diagnose;
	}
	public void setDiagnose(String diagnose) {
		this.diagnose = diagnose;
	}
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
}
