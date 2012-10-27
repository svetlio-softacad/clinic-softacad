package util.dao;

import java.util.Date;
import java.util.Set;

import dao.VisitsDao;
import entity.Doctor;
import entity.Patient;
import entity.Visit;

public class VisitDaoHibernate extends GenericDaoHibernate<Visit> implements VisitsDao{
	
	private static VisitDaoHibernate instance;

	public static VisitDaoHibernate getInstance() {
		if (instance == null) {
			instance = new VisitDaoHibernate(Visit.class);
		}
		return instance;
	}

	protected VisitDaoHibernate(Class<Visit> pojoClass) {
		super(pojoClass);
	}

	@Override
	public Set<Visit> findAllByDoctor(Doctor doctor, Date from, Date to) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Visit> findAllByPatient(Patient patient, Date from, Date to) {
		// TODO Auto-generated method stub
		return null;
	}

}
