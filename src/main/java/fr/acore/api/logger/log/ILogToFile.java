package fr.acore.api.logger.log;

import fr.acore.api.logger.transformer.ILogToFileTransformer;

import java.io.File;
import java.util.List;

public interface ILogToFile<T extends ILog> {

    public T getEncapsulatedLog();
    public File getDestination();

    public List<ILogToFileTransformer> getAttachedTransformers();
    public void attachTransformer(ILogToFileTransformer transformer);
}
