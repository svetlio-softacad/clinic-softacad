package runner;

import java.util.Date;

import dao.DaoFactory;
import dao.DataAccessException;
import entity.Doctor;
import entity.Patient;
import util.HibernateUtil;
import util.dao.DaoFactoryHibernate;

public class Runner {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		try {
			DaoFactory factory = DaoFactoryHibernate.getInstance();
			Doctor d = factory.getDoctorsDao().find(6l);
			factory.getVisitsDao().findAllByDoctor(d, new Date(2012, 1, 1), new Date(2012, 12 , 31));
			System.err.println(d.getFirstName());
			/*
			for(Patient s : factory.getPatientsDao().findAllByDoctor(d)) {
				System.err.println(s.getFirstName());
			}
			
			factory.getDoctorsDao().find(1l);
			factory.getPatientsDao().find(1l);
			factory.getSpecialtiesDao().find(1l);
			factory.getTitlesDao().find(1l);
			factory.getVisitsDao().find(1l);
			
			factory.getDoctorsDao().getAll();
			factory.getPatientsDao().getAll();
			factory.getSpecialtiesDao().getAll();
			factory.getSpecialtiesDao().getAll();
			factory.getVisitsDao().getAll();*/
			
		} catch (DataAccessException e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSessionFactory();
		}
	}

}
