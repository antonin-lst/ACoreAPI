package fr.acore.api.optspec;

import java.util.List;

public interface IOptionSpecParser {

    public boolean allowUnrecognizedOptions();
    public void setAllowUnrecognizedOptions();

    public <T> ITypedOptionSpec<T> addOpt(String optTag, Class<T> optType);

    public IOptionSpecResultSet parse(String... args);

}
