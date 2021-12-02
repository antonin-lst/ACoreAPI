package fr.acore.api.versionning.exception;

/*

Erreur de parsing de la version

 */

public class ParseVersionException extends Exception{

    private static final long serialVersionUID = 6986487554420433168L;

    @Override
    public String getMessage() {
        return "Model : 1.0.0 (major,minor,patch)";
    }
}
