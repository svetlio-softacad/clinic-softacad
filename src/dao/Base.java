package dao;

import java.util.List;

import entity.Persistable;

public interface Base<T extends Persistable> {
	
	List<T> getAll();
	T find(long id);
	void save(T entity);
	
}
