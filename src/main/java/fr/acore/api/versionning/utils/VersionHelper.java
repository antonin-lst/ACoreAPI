package fr.acore.api.versionning.utils;

import fr.acore.api.versionning.exception.ParseVersionException;
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

    public default IVersion toVersion(String version) throws ParseVersionException {
        return VersionHelper.staticToVersion(version);
    }

    public default IVersion toVersion(int major, int minor, int patch){
        return VersionHelper.staticToVersion(major, minor, patch);
    }

    public static IVersion staticToVersion(String version) throws ParseVersionException{
        try {
            int major = Integer.parseInt(version.substring(0, 1));
            int minor = Integer.parseInt(version.substring(2, 3));
            int patch = Integer.parseInt(version.substring(4, 5));

            return staticToVersion(major, minor, patch);
        }catch(Exception e) {
            throw new ParseVersionException();
        }
    }

    public static IVersion staticToVersion(int aMajor, int aMinor, int aPatch){
        return new IVersion() {

            private int major = aMajor;
            private int minor = aMinor;
            private int patch = aPatch;

            @Override
            public int getMajor() {
                return this.major;
            }

            @Override
            public void setMajor(int major) {
                this.major = major;
            }

            @Override
            public int getMinor() {
                return this.minor;
            }

            @Override
            public void setMinor(int minor) {
                this.minor = minor;
            }

            @Override
            public int getPatch() {
                return this.patch;
            }

            @Override
            public void setPatch(int patch) {
                this.patch = patch;
            }
        };
    }
}
