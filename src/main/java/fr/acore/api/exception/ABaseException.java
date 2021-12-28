package fr.acore.api.exception;

import fr.acore.api.logger.IBaseLogger;

public class ABaseException extends Exception{


    private static IBaseLogger defaultThrowLogger;

    public static void setDefaultThrowLogger(IBaseLogger logger){
        defaultThrowLogger = logger;
    }


    private String message;

    private IBaseLogger throwableLogger;

    public ABaseException(){}

    public ABaseException(String message){
        this.message = message;
        throwableLogger = defaultThrowLogger;
    }

    public ABaseException(String message, IBaseLogger throwableLogger){
        this.message = message;
        this.throwableLogger = throwableLogger;
    }

    public IBaseLogger getThrowableLogger() {
        return throwableLogger;
    }

    public void setThrowableLogger(IBaseLogger throwableLogger) {
        this.throwableLogger = throwableLogger;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void log(){
        getThrowableLogger().logErr(message);
    }

}
