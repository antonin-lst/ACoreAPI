package fr.acore.api.logger.transformer;

import fr.acore.api.logger.log.EncapsulatedLogFormat;
import fr.acore.api.logger.log.ILog;
import fr.acore.api.logger.log.ILogToFile;

public interface ILogToFileTransformer<T extends ILogToFile<U>, U extends ILog> extends ILogTransformer<U> {

    public T transformForFile(EncapsulatedLogFormat<T> encapsulatedLogFormat);

}
