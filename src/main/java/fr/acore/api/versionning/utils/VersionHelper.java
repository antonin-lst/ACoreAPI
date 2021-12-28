package fr.acore.api.versionning.utils;

import fr.acore.api.versionning.version.IVersion;

import java.util.List;

    /*

    Helper pour le versionning

     */

public interface VersionHelper {

    //récupération de la version la plus récente dans une liste de version
    public default IVersion getLatestVersion(List<IVersion> versions){
        IVersion currentLatest = versions.get(0);
        for(int i = 1; i < versions.size(); i++){
            IVersion current = versions.get(i);
            if(currentLatest.isOlder(current)) currentLatest = current;
        }
        return  currentLatest;
    }
}
