package fr.acore.api.transform;

public interface ITransformer<T, U> {

    public T transform(U arg);

}
