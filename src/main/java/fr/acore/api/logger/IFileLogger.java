package fr.acore.api.logger;

import fr.acore.api.logger.log.ILog;
import fr.acore.api.logger.log.ILogToFile;
import fr.acore.api.logger.transformer.ILogToFileTransformer;
import fr.acore.api.logger.transformer.ILogTransformer;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public interface IFileLogger<T extends ILogToFile<U>, U extends ILog, V extends ILogToFileTransformer<T, U>, Z extends ILogTransformer<U>> extends IBaseLogger<U, Z>{

    public File getFile();
    public void setFile(File file);

    public void printToFile(T log);
    public void printToFile(T log, V... transformers);

    public default void log(T logToFile, V... transformers){
        log(logToFile.getEncapsulatedLog(), (Z[]) transformers);
    }

    public void enablePrint();
    public void disablePrint();
    public boolean isPrintEnable();

}
