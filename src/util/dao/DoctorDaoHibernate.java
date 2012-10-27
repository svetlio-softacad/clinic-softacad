package util.dao;

import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import util.HibernateUtil;

import dao.DataAccessException;
import dao.DoctorsDao;
import entity.Doctor;
import entity.Patient;

public class DoctorDaoHibernate extends GenericDaoHibernate<Doctor> implements DoctorsDao{
	
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

	@Override
	public Set<Doctor> findAllByPatient(Patient patient, Date from, Date to) throws DataAccessException {
		return findByConditionsWithOther("select d from Doctor d inner join d.visits v where v.patient.id = :id", patient.getId());
	}

}
