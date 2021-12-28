package fr.acore.api.logger.log;

import fr.acore.api.logger.IFileLogger;

import java.io.File;

public interface ILogToFile {

    public ILog getEncapsulatedLog();
    public File getDestination();
}
