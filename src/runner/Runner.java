package runner;

import dao.DataAccessException;
import util.dao.DoctorDaoHibernate;
import util.dao.PatientDaoHibernate;
import util.dao.PersonDaoHibernate;
import util.dao.SpecialtyDaoHibernate;
import util.dao.TitleDaoHibernate;
import util.dao.VisitDaoHibernate;

public class Runner {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			PersonDaoHibernate.getInstance().getAll();
			DoctorDaoHibernate.getInstance().getAll();
			PatientDaoHibernate.getInstance().getAll();
			TitleDaoHibernate.getInstance().getAll();
			SpecialtyDaoHibernate.getInstance().getAll();
			//VisitDaoHibernate.getInstance().getAll();
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
