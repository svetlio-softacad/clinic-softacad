package util.dao;

import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import util.HibernateUtil;

import dao.Daoable;
import dao.DataAccessException;
import entity.Persistable;

public class GenericDaoHibernate<T extends Persistable> implements Daoable<T> {

	protected Logger logger = Logger.getLogger(GenericDaoHibernate.class);
	
	private Class<T> pojoClass;

	protected GenericDaoHibernate(Class<T> pojoClass) {
		this.pojoClass = pojoClass;
	}
	
	@Override
	public List<T> getAll() throws DataAccessException{
		List<T> entities = null;
		Session session = HibernateUtil.getSession();
		try {
			logger.info("Fetching all instances of "
					+ this.pojoClass.getCanonicalName());
			session.beginTransaction();
			Query query = session.createQuery("from "
					+ this.pojoClass.getName());
			entities = query.list();
			if (entities == null) {
				entities = Collections.emptyList();
			}
			logger.debug("A total of " + entities.size() + " fetched");
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			logger.error("Error while fetching all entities of class "
					+ this.pojoClass.getCanonicalName(), e);
			throw new DataAccessException("Error while fetching entities", e);
		}
		return entities;
	}

	@Override
	public T find(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(T entity) {
		// TODO Auto-generated method stub
		
	}

}
