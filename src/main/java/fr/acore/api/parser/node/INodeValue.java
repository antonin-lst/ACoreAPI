package fr.acore.api.parser.node;

/*

Interface d'une node avec une value

 */

import fr.acore.api.string.StringToOtherHelper;

public interface INodeValue extends INode, StringToOtherHelper {

    //getter
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

    //check basique

    public boolean isNull();

    public default boolean isNumber() {
        return isByte(getAsString()) || isDouble(getAsString()) || isFloat(getAsString()) || isInt(getAsString());
    }

    public default boolean isBoolean() {
        return isBoolean(getAsString());
    }

    public default  <T extends Enum<T>> T getAsEnumElement(Class<T> enumClazz){
        return (T) Enum.valueOf(enumClazz, getAsString());
    }

}
