package fr.acore.api.optspec;

import java.util.List;

public interface IOptionSpecResultSet {

    public List<IUnrecognizedOptionSpec> getUnrecognizedOptions();

    public List<IOptionSpec<?>> getLoadedOptionSpec();

    public <T> T valueOf(String optTag);
    public boolean contain(String optTag);

}
