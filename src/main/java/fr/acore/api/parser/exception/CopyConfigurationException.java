package fr.acore.api.parser.exception;

/*

Erreur pendant la copy d'une configuration

 */

public class CopyConfigurationException extends Exception{

    private String message;

    public CopyConfigurationException(String message){
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
