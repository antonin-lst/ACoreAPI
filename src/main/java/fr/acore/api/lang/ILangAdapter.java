package fr.acore.api.lang;

import fr.acore.api.adapter.IAdapter;

public interface ILangAdapter extends IAdapter<String, String> {

    public ILang<?> getLang();

}
