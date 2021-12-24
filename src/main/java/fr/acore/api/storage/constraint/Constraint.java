package fr.acore.api.storage.constraint;

import java.util.List;

public interface Constraint<T extends ConstraintType> {
	
	public T getConstraintType();
	
	public List<Object> getData();
	
	public String toSql();
	
}
