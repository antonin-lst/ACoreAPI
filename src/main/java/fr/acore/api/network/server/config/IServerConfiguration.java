package fr.acore.api.network.server.config;

import fr.acore.api.network.server.queue.config.IQueueConfiguration;
import fr.acore.api.network.server.utils.ServerType;

public interface IServerConfiguration {

    //Type du serveur en question pour le load depuis son fichier INetwork#load()
    public ServerType getServerType();

    public int getPort();
    public void setPort(int port);

    public boolean isAutoStart();
    public void setAutoStart(boolean autoStart);
    public boolean isAutoRestartAfterCrash();
    public void setAutoRestartAfterCrash(boolean autoRestartAfterCrash);

    public IQueueConfiguration getQueueConfiguration();

}
