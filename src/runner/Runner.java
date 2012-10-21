package runner;

import dao.DataAccessException;
import util.dao.DoctorDaoHibernate;

public class Runner {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			DoctorDaoHibernate.getInstance().getAll();
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
