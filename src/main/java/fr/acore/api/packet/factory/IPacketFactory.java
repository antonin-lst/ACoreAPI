package fr.acore.api.packet.factory;

import fr.acore.api.packet.IPacket;
import fr.acore.api.packet.handler.IPacketHandler;

import java.util.List;

public interface IPacketFactory<T extends IPacket> {

    /*

    Factory du système de packet

     */

    //permet de recuperer un packet grace a son id
    public <U extends T> Class<U> getPacketClazz(int packetId);

    //permet d'ajouter un packet a la liste des packet existant
    public void addPacket(int packetId, Class<? extends T> packetClazz);



    /*

    factory des handler

     */
    public void registerHandler(IPacketHandler<T> packetHandler);
    public void unregisterHandler(IPacketHandler<T> packetHandler);
    public List<IPacketHandler<T>> getPacketHandlers();

    public default void handlePacket(T packet){
        if(getPacketHandlers().isEmpty() || packet == null) return;

        for(IPacketHandler<T> handler : getPacketHandlers()){
            if(handler.isHandling(packet)) handler.handlePacket(packet);
        }
    }

}
