package fr.acore.api.lang;

import fr.acore.api.parser.conf.IParsedConfiguration;

import java.util.List;

public interface ILang<T extends IParsedConfiguration<?,?>> {

    public String getName();

    public List<ILangLabel> getAvailableLabels();
    public ILangLabel getLoadedLabel();
    public void setLoadedLabel(String country);

    public T parsedConfiguration();
    public void refreshFromParsedConfiguration();

    public boolean isLoaded();

    public ILangTransformer<?> getLangTransformer();

    public void translate(String origin);
    public void translate(String origin, ILangTransformer<?> externalTransformerSurcharge);
}
