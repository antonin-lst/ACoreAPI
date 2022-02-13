package fr.acore.api.network;

import fr.acore.api.network.server.IProxy;
import fr.acore.api.network.server.IServer;
import fr.acore.api.network.server.utils.ServerType;

import java.nio.file.Path;
import java.util.List;
import java.util.Random;

public interface INetwork {

    public Path getServersPath();
    public List<IServer> getServers();
    public IServer getServer(String name);
    public default boolean containServer(String name){
        return getServer(name) != null;
    }
    public default IProxy getProxyServer(){
        return getServers().stream().filter(iServer -> {return iServer instanceof IProxy;}).map(iServer -> (IProxy) iServer).findFirst().orElse(null);
    }
    public default boolean hasProxy(){
        return getProxyServer() != null;
    }

    public void createServer(String name);
    public void createServer(String name, ServerType serverType);
    public void createServer(String name, ServerType serverType, int port);
    public void createServer(String name, ServerType serverType, int port, boolean install);

    public void deleteServer(String name, boolean confirmed);

    public void setServerOnline(String name);
    public void setServerOffline(String name);

    public void load();
    public void save();

    public default int generateRandomPort(){
        return Integer.parseInt("255" + String.valueOf(new Random().nextInt(9)) + String.valueOf(new Random().nextInt(9)));
    }


}
