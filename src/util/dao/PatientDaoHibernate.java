package util.dao;

import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;

import dao.DataAccessException;
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
	public Set<Patient> findAllByDoctor(Doctor doctor) throws DataAccessException {
		return findByConditionsWithOther("select p from Patient p inner join p.visits v where v.doctor.id = :id", doctor.getId());
	}

	@Override
	public Set<Patient> findAllByDiagnose(final String diagnose) throws DataAccessException {
		return findByCallback(new DaoCallBackVisitor() {
			
			@Override
			public Query visit(Session session) {
				String searchDiagnose = diagnose; 
				Query query = session.createQuery("select p Patient p inner join p.visits v where v.diagnose like :diagnose escape '\\'");
				searchDiagnose = searchDiagnose.replace("\\", "\\\\");
				searchDiagnose = searchDiagnose.replace("%", "\\%");
				searchDiagnose = searchDiagnose.replace("_", "\\_");
				query.setString("diagnose", "%" + searchDiagnose + "%");
				return query;
			}
		});
	}

	@Override
	public Set<Patient> findAllWithExpensiveVisit(double visitCostsAtLeast) {
		// TODO Auto-generated method stub
		return null;
	}

}