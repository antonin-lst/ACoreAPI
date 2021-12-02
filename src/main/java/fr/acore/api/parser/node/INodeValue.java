package fr.acore.api.parser.node;

/*

Interface d'une node avec une value

 */

import fr.acore.api.string.StringToOtherHelper;

public interface INodeValue extends INode, StringToOtherHelper {

    //getter de la value original
    public String getValue();
    //getter de la value avec suprestion des caractere de délimitations
    public String getAsString();


    //element cast en double float int ...
    public default double getAsDouble() {
        return Double.valueOf(getAsString());
    }
    public default float getAsFloat() {
        return Float.valueOf(getAsString());
    }
    public default int getAsInt() {
        return Integer.valueOf(getAsString());
    }
    public default byte getAsByte() {
        return Byte.valueOf(getAsString());
    }
    public default boolean getAsBoolean() {
        return Boolean.valueOf(getAsString());
    }
    public default  <T extends Enum<T>> T getAsEnumElement(Class<T> enumClazz){
        return (T) Enum.valueOf(enumClazz, getAsString());
    }

    
    //check si la value de la node est null
    public boolean isNull();

    //check si la node est un nombre
    public default boolean isNumber() {
        return isByte(getAsString()) || isDouble(getAsString()) || isFloat(getAsString()) || isInt(getAsString());
    }

    //check si la node est un boolean
    public default boolean isBoolean() {
        return isBoolean(getAsString());
    }

}
