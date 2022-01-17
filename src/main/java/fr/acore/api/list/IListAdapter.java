package fr.acore.api.list;

import fr.acore.api.transform.ITransformer;

import java.util.List;

public interface IListAdapter<T, U> extends ITransformer<List<T>, U> {

    public static interface IStringToListAdapter<T> extends IListAdapter<T, String>{

    }

}
