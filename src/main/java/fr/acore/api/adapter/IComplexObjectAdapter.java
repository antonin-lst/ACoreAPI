package fr.acore.api.adapter;

import fr.acore.api.reflection.NonTypedObject;

import java.lang.reflect.Field;

public interface IComplexObjectAdapter<T> extends IAdapter<T, NonTypedObject> {

    public Class<?> getComplexObjectType();
    public void setComplexObjectType(Class<?> clazz);
}
