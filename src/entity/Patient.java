package entity;

import java.util.List;

public class Patient extends Person {
	
	private int age;
	private String egn;
	private List<Visit> visits;
	
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
