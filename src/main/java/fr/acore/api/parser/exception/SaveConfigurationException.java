package fr.acore.api.parser.exception;

/*

Erreur pendant la sauvegarde d'une configuration

 */

public class SaveConfigurationException extends Exception{

    private String message;

    public SaveConfigurationException(String message){
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
