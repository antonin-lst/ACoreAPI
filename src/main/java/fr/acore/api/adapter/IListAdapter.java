package fr.acore.api.adapter;

import java.util.List;

public interface IListAdapter<T, U> extends IAdapter<List<T>, U> {

    public Class<?> getListContentType();
    public void setListContentType(Class<?> clazz);

    public static interface IStringToListAdapter<T> extends IListAdapter<T, String>{

    }

}
