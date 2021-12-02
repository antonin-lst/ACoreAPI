package fr.acore.api.packet.factory;

public interface IPacketFactory<T> {

    /*

    Factory du système de packet

     */

    //permet de recuperer un packet grace a son id
    public Class<T> getPacketClazz(int id);

    //permet d'ajouter un packet a la liste des packet existant
    public <U extends T> void addPacket(int packetId, Class<U> clazz);
}
