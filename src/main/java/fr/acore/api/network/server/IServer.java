package fr.acore.api.network.server;

import fr.acore.api.network.server.config.IServerConfiguration;
import fr.acore.api.network.server.utils.ServerStatus;
import fr.acore.api.network.server.utils.ServerType;

import java.nio.file.Path;

public interface IServer {

        /*

    Gestion du nom d'un serveur (id unique)

     */

    public String getName();
    public void setName(String newName);

    /*

    Gestion du type de serveur

     */

    public default ServerType getServerType(){return getServerConfiguration().getServerType();}

    /*

    Gestion du status du serveur

     */

    public ServerStatus getServerStatus();
    public boolean isOnline();

    /*

    Gestion des fichiers et de la configuration

     */

    public Path getServerPath();
    public void setServerPath(Path serverPath);

    public IServerConfiguration getServerConfiguration();
    public void setServerConfiguration(IServerConfiguration serverConfiguration);
    /*

    delete le serveur en question
    retour l'état du resultat de la supprétion

     */

    public boolean delete();


}
