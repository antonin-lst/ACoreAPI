package fr.acore.api.optspec;

public interface ITypedOptionSpec<T>  extends IOptionSpec {

    public boolean isRequired();
    public ITypedOptionSpec<T> setRequired();

    public boolean isArgRequired();
    public ITypedOptionSpec<T> setArgsRequired();

    public T getDefaultArg();
    public ITypedOptionSpec<T> setDefaultArg(T defaultArg);

    public default boolean hasDefaultArg(){
        return getDefaultArg() != null;
    }

}
