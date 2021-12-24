package fr.acore.api.storage.constraint.query;

import fr.acore.api.storage.constraint.ConstraintType;

public enum QueryConstraintType implements ConstraintType {
	
	WHERE,
	LIKE;

	@Override
	public String getSqlType() {
		return name();
	}

}
