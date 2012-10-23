package util.dao;

import java.util.Set;

import dao.PatientsDao;
import entity.Doctor;
import entity.Patient;

public class PatientDaoHibernate extends GenericDaoHibernate<Patient> implements PatientsDao{
	
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

	@Override
	public Set<Patient> find_all_by_doctor(Doctor doctor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Patient> find_all_by_diagnose(String diagnose) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Patient> find_all_with_expensive_visit(double visitCostsAtLeast) {
		// TODO Auto-generated method stub
		return null;
	}

}