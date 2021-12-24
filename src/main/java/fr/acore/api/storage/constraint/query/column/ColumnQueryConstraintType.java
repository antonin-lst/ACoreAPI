package fr.acore.api.storage.constraint.query.column;

import fr.acore.api.storage.constraint.ConstraintType;

public enum ColumnQueryConstraintType implements ConstraintType {
	
	UPDATE, SELECT;

	@Override
	public String getSqlType() {
		return name();
	}

}
