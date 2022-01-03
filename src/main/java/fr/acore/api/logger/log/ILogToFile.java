package fr.acore.api.logger.log;

import fr.acore.api.logger.transformer.ILogToFileTransformer;

import java.io.File;
import java.util.List;

public interface ILogToFile {

    public ILog getEncapsulatedLog();
    public File getDestination();

    public List<ILogToFileTransformer> getAttachedTransformers();
    public void attachTransformer(ILogToFileTransformer transformer);
}
