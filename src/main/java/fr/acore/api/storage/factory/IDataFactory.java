package fr.acore.api.storage.factory;

import java.util.List;

import fr.acore.api.storage.constraint.query.IQueryConstraint;
import fr.acore.api.storage.table.ITable;


public interface IDataFactory<T> {

	public ITable getTable();
	
	public void loadAll();
	public void saveAll();
	
	public T load(String constraint, Object... data);
	public void save(T obj);
	
	public boolean contain(String constraint, Object... data);
	
	public void insert(T data);
	public void delete(T data);
	public void update(T data);
	public List<T> select(IQueryConstraint queryConstraint);
	public T selectFirst(IQueryConstraint queryConstraint);
	
}
