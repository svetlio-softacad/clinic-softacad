package util.dao;

import entity.Visit;

public class VisitDaoHibernate extends GenericDaoHibernate<Visit>{
	
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

}
