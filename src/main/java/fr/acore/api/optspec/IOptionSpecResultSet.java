package fr.acore.api.optspec;


import fr.acore.api.reflection.NonTypedObject;

import java.util.List;

public interface IOptionSpecResultSet {

    public List<IUnrecognizedOptionSpec> getUnrecognizedOptions();

    public boolean isUnrecognizedOpt(String unrecognizedOptTag);
    public NonTypedObject getUnrecognizedOpt(String unrecognizedOptTag);

    public List<ITypedOptionSpec<?>> getLoadedOptionSpec();

    public boolean isRecognizedOpt(String optTag);
    public NonTypedObject getOpt(String optTag);


}
