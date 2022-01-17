package fr.acore.api.optspec;

public interface IOptionSpec {

    public String getTag();

    public String getParsedArg();
    public void setParsedArg(String arg);

    public default boolean hasParsedArg(){
        return getParsedArg() != null && !getParsedArg().isEmpty();
    }
}
