package util.dao;

import java.util.Date;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;

import dao.DataAccessException;
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
	public Set<Visit> findAllByDoctor(final Doctor doctor, final Date from, final Date to) throws DataAccessException {
		return findByCallback(new DaoCallBackVisitor() {
			
			@Override
			public Query visit(Session session) {
			 Query query = session.createQuery("from Visit v where v.date > :from and date < :to and v.doctor.id = :id ");
			 query.setDate("from", from);
			 query.setDate("to", to);
			 query.setLong("id", doctor.getId());
			 return query;
			}
		});
	}

	@Override
	public Set<Visit> findAllByPatient(final Patient patient, final Date from, final Date to) throws DataAccessException {
		return findByCallback(new DaoCallBackVisitor() {
			
			@Override
			public Query visit(Session session) {
				Query query = session.createQuery("from Visit v where v.date between :from and :to and v.patient.id = :id");
				query.setDate("from", from);
				 query.setDate("to", to);
				 query.setLong("id", patient.getId());
				 return query;
			}
		});
	}

}
