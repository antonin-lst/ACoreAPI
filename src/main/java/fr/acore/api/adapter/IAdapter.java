package fr.acore.api.adapter;

public interface IAdapter<T, U> {

    public T transform(U arg);

}
