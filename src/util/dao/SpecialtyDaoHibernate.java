package util.dao;

import dao.SepcialtiesDao;
import entity.Specialty;

public class SpecialtyDaoHibernate extends GenericDaoHibernate<Specialty> implements SepcialtiesDao{
	
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
