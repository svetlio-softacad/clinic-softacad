package dao;

import java.util.List;

import entity.Persistable;

public interface Daoable<T extends Persistable> {
	
	List<T> getAll() throws DataAccessException;
	T find(long id);
	void save(T entity);
	
}
