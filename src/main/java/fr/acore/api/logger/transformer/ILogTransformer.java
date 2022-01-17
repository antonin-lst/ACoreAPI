package fr.acore.api.logger.transformer;

import fr.acore.api.logger.log.EncapsulatedLogFormat;
import fr.acore.api.logger.log.ILog;
import fr.acore.api.transform.ITransformer;

public interface ILogTransformer<T extends ILog> extends ITransformer<T, EncapsulatedLogFormat<T>> {


}
