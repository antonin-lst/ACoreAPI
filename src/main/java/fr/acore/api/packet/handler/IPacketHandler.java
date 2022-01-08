package fr.acore.api.packet.handler;

import fr.acore.api.packet.IPacket;

import java.util.List;

public interface IPacketHandler<T extends IPacket> {

    public void handlePacket(T packet);

    public List<Class<? extends T>> getHandledPackets();

    public default boolean isHandling(T packet){
        return getHandledPackets().contains(packet.getClass());
    }

}
