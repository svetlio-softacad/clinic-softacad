package util.dao;

import entity.Title;

public class TitleDaoHibernate extends GenericDaoHibernate<Title>{
	
	private static TitleDaoHibernate instance;

	public static TitleDaoHibernate getInstance() {
		if (instance == null) {
			instance = new TitleDaoHibernate(Title.class);
		}
		return instance;
	}

	protected TitleDaoHibernate(Class<Title> pojoClass) {
		super(pojoClass);
	}


}
