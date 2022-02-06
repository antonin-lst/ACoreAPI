package fr.acore.api.logger.transformer;

import fr.acore.api.logger.log.EncapsulatedLogFormat;
import fr.acore.api.logger.log.ILog;
import fr.acore.api.adapter.IAdapter;

public interface ILogTransformer<T extends ILog> extends IAdapter<T, EncapsulatedLogFormat<T>> {


}
