package fr.acore.api.logger.log;

import fr.acore.api.logger.level.ILogLevel;
import fr.acore.api.logger.transformer.ILogTransformer;

import java.util.List;

public interface ILog {

    public ILogLevel getLogLevel();
    public List<String> getContents();
    public void setContents(List<String> contents);

    public List<ILogTransformer> getAttachedTransformers();
    public void attachTransformer(ILogTransformer transformer);

}
