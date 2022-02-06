package fr.acore.api.parser.node;

/*

Interface d'une node avec une value

 */

import fr.acore.api.reflection.NonTypedObject;

public interface INodeValue extends INode, NonTypedObject {

    //check si la value de la node est null
    public boolean isNull();


}
