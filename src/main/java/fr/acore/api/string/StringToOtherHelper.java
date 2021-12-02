package fr.acore.api.string;

/*

Helper pour valider la validitée d'une chaine de caractere avant d'etre parser en quelque chose d'autre


 */

public interface StringToOtherHelper {

    public default boolean isInt(String value){
        try{
            Integer.valueOf(value);
            return true;
        }catch (Exception ex){
            return false;
        }
    }

    public default boolean isDouble(String value){
        try{
            Double.valueOf(value);
            return true;
        }catch (Exception ex){
            return false;
        }
    }

    public default boolean isFloat(String value){
        try{
            Float.valueOf(value);
            return true;
        }catch (Exception ex){
            return false;
        }
    }

    public default boolean isByte(String value){
        try{
            Byte.valueOf(value);
            return true;
        }catch (Exception ex){
            return false;
        }
    }
    
    public default boolean isBoolean(String value){
        try{
            Boolean.valueOf(value);
            return true;
        }catch (Exception ex){
            return false;
        }
    }


}
