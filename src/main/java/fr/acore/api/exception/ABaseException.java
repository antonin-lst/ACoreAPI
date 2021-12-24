package fr.acore.api.exception;

import fr.acore.api.logger.IBaseLogger;

public class ABaseException extends Exception{

    private String message;

    private IBaseLogger throwableLogger;

    public ABaseException(){}

    public ABaseException(String message){
        this.message = message;
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

}
