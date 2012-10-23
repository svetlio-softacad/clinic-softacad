package util.dao;

import dao.SpcialtiesDao;
import entity.Specialty;

public class SpecialtyDaoHibernate extends GenericDaoHibernate<Specialty> implements SpcialtiesDao{
	
	private static SpecialtyDaoHibernate instance;

	public static SpecialtyDaoHibernate getInstance() {
		if (instance == null) {
			instance = new SpecialtyDaoHibernate(Specialty.class);
		}
		return instance;
	}

	protected SpecialtyDaoHibernate(Class<Specialty> pojoClass) {
		super(pojoClass);
	}


}
