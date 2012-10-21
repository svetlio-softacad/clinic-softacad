package util.dao;

import entity.Doctor;

public class DoctorDaoHibernate extends GenericDaoHibernate<Doctor>{
	
	private static DoctorDaoHibernate instance;

	public static DoctorDaoHibernate getInstance() {
		if (instance == null) {
			instance = new DoctorDaoHibernate(Doctor.class);
		}
		return instance;
	}

	protected DoctorDaoHibernate(Class<Doctor> pojoClass) {
		super(pojoClass);
	}

}
