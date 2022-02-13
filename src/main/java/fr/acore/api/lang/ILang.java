package fr.acore.api.lang;

import fr.acore.api.parser.conf.IParsedConfiguration;

import java.util.List;

public interface ILang<T extends IParsedConfiguration<?,?>> {

    public String getName();

    public List<ILangLabel> getAvailableLabels();
    public void setAvailableLabels(List<ILangLabel> availableLabels);
    public ILangLabel getDefaultLabel();
    public void setDefaultLabel(ILangLabel defaultLabel);
    public ILangLabel getLoadedLabel();
    public void setLoadedLabel(ILangLabel loadedLabel);

    public T getParsedConfiguration();
    public void setParsedConfiguration(T parsedConfiguration);
    public void refreshFromParsedConfiguration();

    public void load();

    public boolean isLoaded();
    public void setLoaded(boolean loaded);

    public ILangAdapter getLangTransformer();

    public default String translate(String origin){
        return translate(origin, getLangTransformer());
    }
    public String translate(String origin, ILangAdapter transformer);
}
