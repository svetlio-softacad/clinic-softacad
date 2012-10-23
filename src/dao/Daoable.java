package dao;

import java.util.List;

import entity.Persistable;

public interface Daoable<T extends Persistable> {
	
	List<T> getAll() throws DataAccessException;
	T find(long id) throws DataAccessException;
	void save(T entity) throws DataAccessException;
	void delete(T entity) throws DataAccessException;
	
}
