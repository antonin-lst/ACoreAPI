package fr.acore.api.string;

import fr.acore.api.list.IListAdapter;
import fr.acore.api.transform.ITransformer;

import java.util.Collections;
import java.util.List;

public interface NonTypedObject extends IStringHelper{

    public Object getObject();

    public ITransformer<String, NonTypedObject> getStringTransformer();
    public void setStringTransformer(ITransformer<String, NonTypedObject> stringTransformer);

    public default String getAsString(){
        return getStringTransformer().transform(this);
    }
    public default double getAsDouble() {
        return Double.parseDouble(getAsString());
    }
    public default float getAsFloat() {
        return Float.parseFloat(getAsString());
    }
    public default int getAsInt() {
        return Integer.parseInt(getAsString());
    }
    public default byte getAsByte() {
        return Byte.parseByte(getAsString());
    }
    public default long getAsLong(){ return Long.parseLong(getAsString());}
    public default boolean getAsBoolean() {
        return Boolean.parseBoolean(getAsString());
    }
    public default  <T extends Enum<T>> T getAsEnumElement(Class<T> enumClazz){
        return (T) Enum.valueOf(enumClazz, getAsString());
    }

    public default <T> List<T> getAsAdaptedList(IListAdapter<T, NonTypedObject> adapter){
        return adapter.transform(this);
    }
    public void setListAdapter(IListAdapter<?, NonTypedObject> adapter);
    public <T> IListAdapter<T, NonTypedObject> getListAdapter();
    public default <T> List<T> getAsList(){
        return (List<T>) getObject();
    }

    public default boolean isInt(){
        return isInt(getAsString());
    }

    public default boolean isDouble(){
        return isDouble(getAsString());
    }

    public default boolean isFloat(){
        return isFloat(getAsString());
    }

    public default boolean isByte(){
        return isByte(getAsString());
    }

    public default boolean isLong(){
        return isLong(getAsString());
    }

    public default boolean isBoolean(){
        return isBoolean(getAsString());
    }

    public default boolean isNumber() {
        return isByte() || isDouble() || isFloat() || isInt();
    }

    public default boolean isPrimitive(){ return isBoolean() || isNumber();}
    public default boolean isCollection(){
        return Collections.class.isAssignableFrom(getObject().getClass());
    }
    public default boolean isAdaptableCollection(){
        return getListAdapter() != null;
    }
    public default boolean isComplexObject(){
        return !isPrimitive() && !isCollection() && !isAdaptableCollection();
    }


    public static class DefaultStringTransformer implements ITransformer<String, NonTypedObject>{
        @Override
        public String transform(NonTypedObject arg) {
            return String.valueOf(arg.getObject());
        }
    }
    public static class QuotedStringTransformer extends DefaultStringTransformer{

        @Override
        public String transform(NonTypedObject arg) {
            String value = String.valueOf(arg.getObject());

            String vs = value.startsWith("\"") ? value.replaceFirst("\"", "") : value;
            vs = vs.endsWith("\"") ? vs.substring(0, vs.length() - 1) : vs;
            return vs;
        }
    }

}
