package fr.acore.api.string;

/*

Helper chaines de caracteres

 */

import java.util.ArrayList;
import java.util.List;

public interface IStringHelper {

    //permet de remplacer un regex dans une chaine de caractere et dans une liste de chaines
    public default List<String> replace(List<String> chaines, String regex, String data){
        List<String> result = new ArrayList<>();
        for(String target : chaines){
            result.add(replace(target, regex, data));
        }
        return result;
    }

    public default String replace(String chaine, String regex, String data) {
        chaine = chaine.replace(regex, data);
        return chaine;
    }


    /*

    Validation de type de données dans les chaines de caractéres pour des cast

     */

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

    public default boolean isLong(String value){
        try{
            Long.parseLong(value);
            return true;
        }catch (Exception exception){
            return false;
        }
    }

    public default boolean isBoolean(String value){
        if(value.equalsIgnoreCase("true") || value.equalsIgnoreCase("false")) return true;

        return false;
    }
}
