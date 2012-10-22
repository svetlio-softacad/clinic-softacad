package util.dao;

import entity.Patient;

public class PatientDaoHibernate extends GenericDaoHibernate<Patient>{
	
	private static PatientDaoHibernate instance;

	public static PatientDaoHibernate getInstance() {
		if (instance == null) {
			instance = new PatientDaoHibernate(Patient.class);
		}
		return instance;
	}

	protected PatientDaoHibernate(Class<Patient> pojoClass) {
		super(pojoClass);
	}

}