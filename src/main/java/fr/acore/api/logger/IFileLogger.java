package fr.acore.api.logger;

import fr.acore.api.logger.log.ILogToFile;
import fr.acore.api.logger.transformer.ILogToFileTransformer;

import java.io.File;

public interface IFileLogger extends IBaseLogger{

    public File getFile();
    public void setFile(File file);

    public void printToFile(ILogToFile log);
    public void printToFile(ILogToFile log, ILogToFileTransformer... transformers);


    public default void log(ILogToFile log, ILogToFileTransformer... transformers){
        log(log.getEncapsulatedLog(), transformers);
    }

}
