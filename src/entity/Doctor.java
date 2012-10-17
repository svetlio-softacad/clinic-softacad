package entity;

import java.util.List;
import java.util.Set;

public class Doctor extends Person {
	
	private Title title;
	private List<Visit> visits;
	private Set<Specialty> specialties;
	
	public Title getTitle() {
		return title;
	}
	public void setTitle(Title title) {
		this.title = title;
	}
}
