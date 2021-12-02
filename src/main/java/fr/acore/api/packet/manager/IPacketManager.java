package fr.acore.api.packet.manager;

import fr.acore.api.packet.IPacket;
import fr.acore.api.packet.factory.IPacketFactory;

public interface IPacketManager<T extends IPacket, U> {

    /*

    Base d'un manager de packet

     */

    //envoie un packet
    public abstract void sendPacket(T packet);

    //recoie le packet parsé
    public abstract void handlePacket(U parsedPacket);

    //Factory
    public IPacketFactory<T> getPacketFactory();


}
