package fr.acore.api.logger;

/*

Interface de base d'un logger


 T est la class Log erite de ILog
 U est la class mere de transformation des log erite de ILogTransformer

 */

import fr.acore.api.logger.log.ILog;
import fr.acore.api.logger.log.ILogToFile;
import fr.acore.api.logger.transformer.ILogTransformer;

import java.util.List;

public interface IBaseLogger<T extends ILog, U extends ILogTransformer<T>> {

    //format
    public String getMessageFormat();
    public void setMessageFormat(String format);

    //gestion des transformer par defaults
    public List<U> getDefaultTransformers();
    public void addDefaultTransformer(U transformer);

    //methode de logging
    public void log(T log);
    public void log(T log, U... transformers);

    //gestion des Strings
    public void log(String... args);
    public void logWarn(String... args);
    public void logErr(String... args);

    //gestion des objects (apelle la methode log(String...) avec une convertion
    public void log(Object... args);
    public void logWarn(Object... args);
    public void logErr(Object... args);

}
