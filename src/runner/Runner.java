package runner;

import java.util.Date;

import dao.DataAccessException;
import entity.Doctor;
import entity.Patient;
import entity.Specialty;
import entity.Visit;
import util.HibernateUtil;
import util.dao.DoctorDaoHibernate;
import util.dao.PatientDaoHibernate;
import util.dao.SpecialtyDaoHibernate;
import util.dao.TitleDaoHibernate;
import util.dao.VisitDaoHibernate;

public class Runner {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		try {		
			Doctor d = DoctorDaoHibernate.getInstance().find(6l);
			VisitDaoHibernate.getInstance().findAllByDoctor(d, new Date(2012, 1, 1), new Date(2012, 12 , 31));
			//System.err.println(d.getFirstName());s
			//for(Patient s : PatientDaoHibernate.getInstance().findAllByDoctor(d)) {
			//	System.err.println(s.getFirstName());
			//}
			//PatientDaoHibernate.getInstance().find(1l);
			//SpecialtyDaoHibernate.getInstance().find(1l);
			//TitleDaoHibernate.getInstance().find(1l);
			//VisitDaoHibernate.getInstance().find(1l);
			//DoctorDaoHibernate.getInstance().getAll();
			//PatientDaoHibernate.getInstance().getAll();
			//TitleDaoHibernate.getInstance().getAll();
			//SpecialtyDaoHibernate.getInstance().getAll();
			//VisitDaoHibernate.getInstance().getAll();
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSessionFactory();
		}
	}

}
