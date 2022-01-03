package fr.acore.api.logger;

import fr.acore.api.exception.ABaseException;

public interface IThrowableLogger extends IBaseLogger {

    public void logException(ABaseException exception);

}
