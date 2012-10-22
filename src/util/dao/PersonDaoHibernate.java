package util.dao;

import entity.Person;

public class PersonDaoHibernate extends GenericDaoHibernate<Person>{
	
	private static PersonDaoHibernate instance;

	public static PersonDaoHibernate getInstance() {
		if (instance == null) {
			instance = new PersonDaoHibernate(Person.class);
		}
		return instance;
	}

	protected PersonDaoHibernate(Class<Person> pojoClass) {
		super(pojoClass);
	}

}