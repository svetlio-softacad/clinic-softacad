package util.dao;

import dao.DaoFactory;
import dao.DoctorsDao;
import dao.PatientsDao;
import dao.VisitsDao;

public class DaoFactoryHibernate implements DaoFactory {
	
	private static DaoFactory instance;
	
	private DaoFactoryHibernate(){
		
	}
	
	public static DaoFactory getInstance() {
		if(instance == null) {
			instance = new DaoFactoryHibernate();
		}
		return instance;
	}

	@Override
	public DoctorsDao getDoctorsDao() {
		return DoctorDaoHibernate.getInstance();
	}

	@Override
	public PatientsDao getPatientsDao() {
		return PatientDaoHibernate.getInstance();
	}

	@Override
	public VisitsDao getVisitsDao() {
		return VisitDaoHibernate.getInstance();
	}

}
