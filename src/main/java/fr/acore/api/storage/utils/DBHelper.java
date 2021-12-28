package fr.acore.api.storage.utils;

import fr.acore.api.storage.column.Column;
import fr.acore.api.storage.table.Table;

import java.lang.reflect.Field;

public interface DBHelper {

    public default String getRealColumnName(Field columnField) {
        return columnField.getDeclaredAnnotation(Column.class) != null ? columnField.getDeclaredAnnotation(Column.class).columnName() : columnField.getName();
    }

    public default String getRealClassName(Class<?> clazz) {
        return clazz.getDeclaredAnnotation(Table.class) != null	? clazz.getDeclaredAnnotation(Table.class).name() : clazz.getSimpleName();
    }

}
