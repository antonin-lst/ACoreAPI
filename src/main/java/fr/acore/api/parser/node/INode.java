package fr.acore.api.parser.node;

    /*

    Interface d'un entry d'une configuration chargée en ram

     */

public interface INode {

    //nom de la node
    public String getName();
    //parent de la node peut etre null si node Racine
    public INode getParent();
    //detection des nodes racines
    public default boolean isNodeRacine(){
        return getParent() == null;
    }
}
