package fr.acore.api.logger;

import fr.acore.api.exception.ABaseException;
import fr.acore.api.logger.log.ILog;
import fr.acore.api.logger.transformer.ILogTransformer;

public interface IThrowableLogger<T extends ILog, U extends ILogTransformer<T>> extends IBaseLogger<T, U> {

    public void logException(ABaseException exception);

}
