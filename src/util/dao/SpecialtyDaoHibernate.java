package util.dao;

import entity.Specialty;

public class SpecialtyDaoHibernate extends GenericDaoHibernate<Specialty>{
	
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
