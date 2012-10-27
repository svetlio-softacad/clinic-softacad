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
	public Set<Doctor> findAllByPatient(Patient patirnt, Date from, Date to) throws DataAccessException {
		List<Doctor> entities = null;
		Session session = HibernateUtil.getSession();
		try {
			logger.info("Fetching all instances of "
					+ this.pojoClass.getCanonicalName());
			session.beginTransaction();
			Query query = session.createQuery("from "
					+ this.pojoClass.getName());
			entities = query.list();
			if (entities == null) {
				entities = Collections.emptyList();
			}
			logger.debug("A total of " + entities.size() + " fetched");
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			logger.error("Error while fetching all entities of class "
					+ this.pojoClass.getCanonicalName(), e);
			throw new DataAccessException("Error while fetching entities", e);
		}
		return new HashSet<Doctor>(entities);
	}

}
