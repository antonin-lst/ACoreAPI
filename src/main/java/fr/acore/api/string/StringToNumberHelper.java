package fr.acore.api.string;

/*

Helper pour valider la validité des cast pour les chiffres


 */

public interface StringToNumberHelper {

    public default boolean isInt(String number){
        try{
            Integer.valueOf(number);
            return true;
        }catch (Exception ex){
            return false;
        }
    }

    public default boolean isDouble(String number){
        try{
            Double.valueOf(number);
            return true;
        }catch (Exception ex){
            return false;
        }
    }

    public default boolean isFloat(String number){
        try{
            Float.valueOf(number);
            return true;
        }catch (Exception ex){
            return false;
        }
    }

    public default boolean isByte(String number){
        try{
            Byte.valueOf(number);
            return true;
        }catch (Exception ex){
            return false;
        }
    }


}
