package fr.acore.api.network.server.queue;

import fr.acore.api.network.player.IOnlinePlayer;
import fr.acore.api.network.server.IServer;
import fr.acore.api.network.server.online.IOnlineServer;
import fr.acore.api.network.server.queue.config.IQueueConfiguration;

import java.util.PriorityQueue;

public interface IQueue {

    /*

    Interface d'une file d'attente d'un serveur

     */

    //instance du serveur cible
    public IOnlineServer getServer();

    //configuration de la queue
    public IQueueConfiguration getConfiguration();
    public void setConfiguration(IQueueConfiguration queueConfiguration);

    //gestion des des joueurs dans la file d'atente
    public PriorityQueue<IOnlinePlayer> getContentPlayers();
    public void addPlayer(IOnlinePlayer player);
    public void removePlayer(IOnlinePlayer player);
    public boolean containPlayer(IOnlinePlayer player);

    /*

    Gestion de la position des joueurs dans la file d'attente

     */

    public int getPlayerPosition(String playerName);
    public int getPlayerPosition(IOnlinePlayer player);

    public IOnlinePlayer getFirstPlayer();
    public void nextPlayer();

}
