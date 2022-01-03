package fr.acore.api.logger.transformer;

import fr.acore.api.logger.log.ILogToFile;

public interface ILogToFileTransformer extends ILogTransformer{

    public <T extends ILogToFile> T transformForFile(String logToFileFormat, T logToFile);

}
