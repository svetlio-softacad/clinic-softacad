package util.dao;

import dao.TitlesDao;
import entity.Title;

public class TitleDaoHibernate extends GenericDaoHibernate<Title> implements TitlesDao{
	
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
