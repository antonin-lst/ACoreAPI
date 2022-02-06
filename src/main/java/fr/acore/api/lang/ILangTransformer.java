package fr.acore.api.lang;

import fr.acore.api.adapter.IAdapter;

public interface ILangTransformer extends IAdapter<String, String> {

    public ILang<?> getLang();

}
