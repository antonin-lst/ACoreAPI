package fr.acore.api.logger.transformer;

import fr.acore.api.logger.log.ILog;

public interface ILogTransformer {

    public <T extends ILog> T transform(String format, T log);

}
