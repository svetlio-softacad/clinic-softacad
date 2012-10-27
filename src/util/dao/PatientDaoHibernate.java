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
	public Set<Patient> findAllByDoctor(Doctor doctor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Patient> findAllByDiagnose(String diagnose) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Patient> findAllWithExpensiveVisit(double visitCostsAtLeast) {
		// TODO Auto-generated method stub
		return null;
	}

}