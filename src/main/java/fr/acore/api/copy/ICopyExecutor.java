package fr.acore.api.copy;

public interface ICopyExecutor<T, U extends ICopyProcess<T>> {

    public U getCopyProcess();

    public T copyFromProcess();

}
