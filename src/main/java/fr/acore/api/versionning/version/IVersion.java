package fr.acore.api.versionning.version;

/*

Interface d'une version des projets ACore

 */

public interface IVersion {

    //version majeure d'un projet exemple 1.x ou 2.x
    public int getMajor();
    public void setMajor(int major);
    //version mineure d'un projet exemple 1.1.x ou 1.5.x
    public int getMinor();
    public void setMinor(int minor);
    //petit debug sur le projet les versions mineurs d'une version majeure peuvent contenir toute autant de patch quelle le veulent x.x.12
    public int getPatch();
    public void setPatch(int patch);


    /*

	Comparaison des versions

	 */

    public default boolean isOlder(IVersion compare) {
        if (compare.getMajor() < this.getMajor())
            return true;
        if (compare.getMinor() < this.getMinor())
            return true;
        if (compare.getPatch() < this.getPatch())
            return true;
        return false;
    }

    public default boolean isEqual(IVersion compare) {
        return (compare.getMajor() == this.getMajor() && compare.getMinor() == this.getMinor()
                && compare.getPatch() == this.getPatch());
    }

    public default boolean isNewer(IVersion compare) {
        if (compare.getMajor() > this.getMajor())
            return true;
        if (compare.getMinor() > this.getMinor())
            return true;
        if (compare.getPatch() > this.getPatch())
            return true;
        return false;
    }

    //serialisation par default des versions
    public default String getVersion(){
        return String.valueOf(this.getMajor()) + "." + String.valueOf(this.getMinor()) + "." + String.valueOf(this.getPatch());
    }
}
