package util.dao;

import java.util.Date;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;

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
	public Set<Doctor> findAllByPatient(final Patient patient, Date from, Date to) throws DataAccessException {
		//return findByConditionsWithOther("select d from Doctor d inner join d.visits v where v.patient.id = :id", patient.getId());
		return findByCallback(new DaoCallBackVisitor() {
			
			@Override
			public Query visit(Session session) {
				Query query = session.createQuery("select d from Doctor d inner join d.visits v where v.patient.id = :id");
				query.setLong("id", patient.getId());
				return query;
			}
		});
	}

}
