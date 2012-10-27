package util.dao;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import util.HibernateUtil;

import dao.Daoable;
import dao.DataAccessException;
import entity.Doctor;
import entity.Persistable;

public class GenericDaoHibernate<T extends Persistable> implements Daoable<T> {

	protected Logger logger = Logger.getLogger(GenericDaoHibernate.class);
	
	protected Class<T> pojoClass;

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
	public T find(long id) throws DataAccessException {
		T entity = null;
		Session session = HibernateUtil.getSession();
		try {
				logger.info("Fething " + this.pojoClass + " instance with id "
						+ id);
				session.beginTransaction();
				entity = ((T) session.get(this.pojoClass, id));
				session.getTransaction().commit();
			} catch (HibernateException e) {
				session.getTransaction().rollback();
				logger.error("Error while searching entity of type "
						+ this.pojoClass.getCanonicalName() + "by primary key", e);
				throw new DataAccessException(
						"Error while searching by primary key", e);
			}
			return entity;
	}

	@Override
	public void save(T entity) throws DataAccessException {

		Session session = HibernateUtil.getSession();

		try {

			logger.info("Saving " + this.pojoClass.getCanonicalName()

					+ " instance");

			session.beginTransaction();

			session.saveOrUpdate(entity);

			session.getTransaction().commit();

		} catch (HibernateException e) {

			session.getTransaction().rollback();

			logger.error(
					"Error while saving entity of class "

							+ this.pojoClass.getCanonicalName(), e);

			throw new DataAccessException("Error while saving entity", e);
		}
	}


	@Override
	public void delete(T entity) throws DataAccessException {
		Session session = HibernateUtil.getSession();
		try {
			logger.info("Deleting " + this.pojoClass.getCanonicalName()
					+ " instance");
			session.beginTransaction();
			session.delete(entity);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			logger.error("Error while deleting entity of class "
					+ this.pojoClass.getCanonicalName(), e);
			throw new DataAccessException("Error while deleting entity", e);
		}
	}
	
	protected Set<T> findByConditionsWithOther(String hql, long id) throws DataAccessException {
		List<T> entities = null;
		Session session = HibernateUtil.getSession();
		try {
			logger.info("Fetching instances of "
					+ this.pojoClass.getCanonicalName());
			session.beginTransaction();
			Query query = session.createQuery("from Doctor d join visits v where v.patient.id = :id");
			query.setLong("id", id);
			entities = query.list();
			if (entities == null) {
				entities = Collections.emptyList();
			}
			logger.debug("A total of " + entities.size() + " fetched");
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			logger.error("Error while fetching entities of class "
					+ this.pojoClass.getCanonicalName(), e);
			throw new DataAccessException("Error while fetching entities", e);
		}
		return new HashSet<T>(entities);
	}
}
