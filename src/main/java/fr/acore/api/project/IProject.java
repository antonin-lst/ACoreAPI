package fr.acore.api.project;

import fr.acore.api.exception.ABaseException;
import fr.acore.api.logger.IBaseLogger;
import fr.acore.api.logger.IFileLogger;
import fr.acore.api.logger.IThrowableLogger;
import fr.acore.api.reflection.ReflectionHelper;

import java.io.File;
import java.net.URISyntaxException;

public interface IProject extends ReflectionHelper {

    //gestion de la racine du projet
    public static File getProjectDirectory() {
        try {
            return new File(IProject.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getParentFile();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }

    //gestion du logger d'erreur
    public default void setDefaultThrowLogger(){
        try {

            File logsFile = new File(getProjectDirectory(), "logs");
            if(!logsFile.exists()) logsFile.mkdir();

            IFileLogger logger = (IFileLogger) Class.forName("fr.acore.logger.impl.BasicExceptionThrowLogger").newInstance();
            logger.setFile(new File(logsFile, "errorLog.txt"));

            setThrowLogger((IThrowableLogger) logger);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public default void setThrowLogger(IThrowableLogger logger){
        ABaseException.setDefaultThrowLogger(logger);
    }

    //gestion du logging du Projet
    public IBaseLogger getLogger();

    public default void log(String... logs){
        getLogger().log(logs);
    }
    public default void logWarn(String... logs){
        getLogger().logWarn(logs);
    }
    public default void logErr(String... logs){
        getLogger().logErr(logs);
    }



}
