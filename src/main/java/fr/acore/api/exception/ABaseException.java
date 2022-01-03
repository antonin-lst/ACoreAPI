package fr.acore.api.exception;

import fr.acore.api.logger.IBaseLogger;
import fr.acore.api.logger.IThrowableLogger;
import fr.acore.api.logger.transformer.ILogTransformer;
import fr.acore.api.reflection.ReflectionHelper;

import java.util.Arrays;

public class ABaseException extends Exception implements ReflectionHelper {

    private static IThrowableLogger defaultThrowLogger;

    public static void setDefaultThrowLogger(IThrowableLogger logger){
        defaultThrowLogger = logger;
    }

    private String message;

    private IThrowableLogger throwableLogger;

    public ABaseException(){}

    public ABaseException(String message){
        this.message = message;
        throwableLogger = defaultThrowLogger;
    }

    public ABaseException(String message, IThrowableLogger throwableLogger){
        this.message = message;
        this.throwableLogger = throwableLogger;
    }

    public IThrowableLogger getThrowableLogger() {
        return throwableLogger;
    }

    public void setThrowableLogger(IThrowableLogger throwableLogger) {
        this.throwableLogger = throwableLogger;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    @Override
    public void printStackTrace() {
        if( getThrowableLogger() != null){
            getThrowableLogger().logException(this);
        }else{
            super.printStackTrace();
        }
    }

    public String getSerializedStacktrace(){
        StringBuilder serializedStacktrace = new StringBuilder();
        for(StackTraceElement stackTraceElement : getStackTrace()){
            serializedStacktrace.append(stackTraceElement.toString()).append("\n");
        }
        return serializedStacktrace.toString();
    }

}
