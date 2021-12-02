package fr.acore.api.parser.exception;

/*

Erreur pendant le chargement d'une configuration

 */

public class LoadConfigurationException extends Exception{

    private String message;

    public LoadConfigurationException(String message){
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
