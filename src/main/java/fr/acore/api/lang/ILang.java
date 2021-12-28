package fr.acore.api.lang;

import fr.acore.api.parser.conf.IParsedConfiguration;

public interface ILang<T extends IParsedConfiguration<?,?>> {

    public T parsedConfiguration();
    public void refreshFromParsedConfiguration();

    public boolean isLoaded();

    public ILangTransformer<?> getLangTransformer();

    public void translate(String origin);
    public void translate(String origin, ILangTransformer<?> externalTransformerSurcharge);
}
