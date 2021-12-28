package fr.acore.api.logger.log;

import fr.acore.api.logger.level.ILogLevel;

import java.util.List;

public interface ILog {

    public ILogLevel getLogLevel();
    public List<String> getContents();
    public void setContents(List<String> contents);


}
