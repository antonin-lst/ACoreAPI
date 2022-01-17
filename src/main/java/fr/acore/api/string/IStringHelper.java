package fr.acore.api.string;

/*

Helper chaines de caracteres

 */

import fr.acore.api.list.IListAdapter;
import fr.acore.api.transform.ITransformer;

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

    methode utile pour la création rapide d'instance de l'interface NonTypedObject

     */

    public default NonTypedObject ntoPrimitive(Object obj){

        return nto(obj, new NonTypedObject.DefaultStringTransformer(), null);
    }

    public default NonTypedObject ntoStringAdaptable(Object obj, ITransformer<String, NonTypedObject> stringTransformer){
        return nto(obj, stringTransformer, null);
    }

    public default NonTypedObject ntoListAdaptable(Object obj, IListAdapter<?, NonTypedObject> listAdapter){
        return nto(obj, new NonTypedObject.DefaultStringTransformer(), listAdapter);
    }

    public default NonTypedObject ntoQuotedStringListAdaptable(Object obj, IListAdapter<?, NonTypedObject> listAdapter){
        return nto(obj, new NonTypedObject.QuotedStringTransformer(), listAdapter);
    }

    public default NonTypedObject ntoQuoted(Object obj){
        return nto(obj, new NonTypedObject.QuotedStringTransformer(), null);
    }


    public default NonTypedObject nto(Object obj, ITransformer<String, NonTypedObject> stringTransformer, IListAdapter<?, NonTypedObject> listAdapter){
        return new NonTypedObject() {

            private ITransformer<String, NonTypedObject> stringTransformer;
            private IListAdapter<?, NonTypedObject> adapter = listAdapter;

            @Override
            public Object getObject() {
                return obj;
            }

            @Override
            public ITransformer<String, NonTypedObject> getStringTransformer() {
                return null;
            }

            @Override
            public void setStringTransformer(ITransformer<String, NonTypedObject> stringTransformer) {

            }

            @Override
            public <T> IListAdapter<T, NonTypedObject> getListAdapter() {
                return (IListAdapter<T, NonTypedObject>) adapter;
            }

            @Override
            public void setListAdapter(IListAdapter<?, NonTypedObject> adapter) {
                this.adapter = adapter;
            }
        };
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
