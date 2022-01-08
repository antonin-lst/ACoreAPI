package fr.acore.api.optspec;

public interface IOptionSpec<T> {

    public String getTag();

    public boolean isRequired();
    public IOptionSpec<T> setRequired();

    public boolean isArgRequired();
    public IOptionSpec<T> setArgsRequired();

    public T getDefaultArg();
    public IOptionSpec<T> setDefaultArg(T defaultArg);

    public default boolean hasDefaultValue(){
        return getDefaultArg() != null;
    }

}
