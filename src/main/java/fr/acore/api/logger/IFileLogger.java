package fr.acore.api.logger;

import fr.acore.api.logger.log.ILogToFile;

import java.io.File;

public interface IFileLogger extends IBaseLogger{

    public File getFile();
    public void setFile(File file);

    public void printToFile(ILogToFile log);
}
