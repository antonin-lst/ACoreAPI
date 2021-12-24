package fr.acore.api.logger;

/*

Interface de base d'un logger

 */

import fr.acore.api.logger.log.ILog;

public interface IBaseLogger {

    //methode de logging
    public void log(ILog log);

    //gestion des Strings
    public void log(String... args);
    public void logWarn(String... args);
    public void logErr(String... args);

    //gestion des objects (apelle la methode log(String...) avec une convertion
    public void log(Object... args);
    public void logWarn(Object... args);
    public void logErr(Object... args);

}
