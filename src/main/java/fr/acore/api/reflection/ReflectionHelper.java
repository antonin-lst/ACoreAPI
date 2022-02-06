package fr.acore.api.reflection;

import fr.acore.api.adapter.IAdapter;
import fr.acore.api.adapter.IComplexObjectAdapter;
import fr.acore.api.adapter.IListAdapter;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;

public interface ReflectionHelper {

    /*
     * Methode Reflection
     *
     */

    public default Method getMethod(Object obj, String name, Class<?>... clazz) throws Exception{
        return getMethod(obj.getClass(), name, clazz);
    }

    public default Method getMethod(Class<?> clazz, String name, Class<?>... argumentsClazz) throws Exception{
        Method method = clazz.getDeclaredMethod(name, argumentsClazz);
        if(!method.isAccessible()) method.setAccessible(true);

        return method;
    }

    public default Object invokeMethod(Method method, Object obj, Object... args) throws Exception{
        return method.invoke(obj, args);
    }

    public default Object invokeMethod(Object obj, String name) throws Exception { return invokeMethod(obj, name, true); }
    public default Object invokeMethod(Object obj, String name, boolean declared) throws Exception {
        Method met = declared ? obj.getClass().getDeclaredMethod(name) : obj.getClass().getMethod(name);
        return met.invoke(obj);
    }

    /*
     * Field Reflection
     *
     */
    public default Object getFieldObject(Object object, Field field) throws Exception { return field.get(object); }
    public default Field getField(Object clazz, String name) throws Exception { return getField(clazz, name, true); }
    public default Field getField(Object clazz, String name, boolean declared) throws Exception { return getField(clazz.getClass(), name, declared); }
    public default Field getField(Class<?> clazz, String name) throws Exception { return getField(clazz, name, true); }
    public default Field getField(Class<?> clazz, String name, boolean declared) throws Exception {
        Field field = declared ? clazz.getDeclaredField(name) : clazz.getField(name);
        if (!field.isAccessible()) {
            field.setAccessible(true);
        }

        return field;
    }


    /*

    methode utile pour la création rapide d'instance de l'interface NonTypedObject

     */

    public default NonTypedObject ntoPrimitive(Object obj){

        return nto(obj, new NonTypedObject.DefaultStringTransformer(), null, null);
    }

    public default NonTypedObject ntoStringAdaptable(Object obj, IAdapter<String, NonTypedObject> stringTransformer){
        return nto(obj, stringTransformer, null, null);
    }

    public default NonTypedObject ntoListAdaptable(Object obj, IListAdapter<?, NonTypedObject> listAdapter){
        return nto(obj, new NonTypedObject.DefaultStringTransformer(), listAdapter, null);
    }

    public default NonTypedObject ntoQuotedStringListAdaptable(Object obj, IListAdapter<?, NonTypedObject> listAdapter){
        return nto(obj, new NonTypedObject.QuotedStringTransformer(), listAdapter, null);
    }

    public default NonTypedObject ntoQuoted(Object obj){
        return nto(obj, new NonTypedObject.QuotedStringTransformer(), null, null);
    }


    public default NonTypedObject nto(Object obj, IAdapter<String, NonTypedObject> sAdapter, IListAdapter<?, NonTypedObject> lAdapter, IComplexObjectAdapter<?> coAdapter){
        return new NonTypedObject() {

            private IAdapter<String, NonTypedObject> stringAdapter = sAdapter;
            private IListAdapter<?, NonTypedObject> listAdapter = lAdapter;
            private IComplexObjectAdapter<?> complexObjectAdapter = coAdapter;

            @Override
            public Object getObject() {
                return obj;
            }

            @Override
            public IAdapter<String, NonTypedObject> getStringAdapter() {
                return this.stringAdapter;
            }

            @Override
            public void setStringAdapter(IAdapter<String, NonTypedObject> stringAdapter) {
                this.stringAdapter = stringAdapter;
            }


            @Override
            public <T> IListAdapter<T, NonTypedObject> getListAdapter() {
                return (IListAdapter<T, NonTypedObject>) listAdapter;
            }

            @Override
            public void setListAdapter(IListAdapter<?, NonTypedObject> adapter) {
                this.listAdapter = adapter;
            }

            @Override
            public <T> IComplexObjectAdapter<T> getComplexObjectAdapter() {
                return (IComplexObjectAdapter<T>) this.complexObjectAdapter;
            }

            @Override
            public void setComplexObjectAdapter(IComplexObjectAdapter<?> complexObjectAdapter) {
                this.complexObjectAdapter = complexObjectAdapter;
            }
        };
    }



    /*

    Methode de reflection sur un NonTypedObject

     */

    public default boolean injectField(Field field, Object instance, NonTypedObject value) throws IllegalAccessException {
        try{
            if(!field.isAccessible()) field.setAccessible(true);

            Class<?> fieldType = field.getType();

            if(fieldType.equals(int.class) || fieldType.equals(Integer.class)){
                field.setInt(instance, value.getAsInt());
            }else if(fieldType.equals(double.class) || fieldType.equals(Double.class)){
                field.setDouble(instance, value.getAsDouble());
            }else if(fieldType.equals(float.class) || fieldType.equals(Float.class)){
                field.setFloat(instance, value.getAsFloat());
            }else if(fieldType.equals(boolean.class) || fieldType.equals(Boolean.class)){
                field.setBoolean(instance, value.getAsBoolean());
            }else if(fieldType.equals(long.class) || fieldType.equals(Long.class)){
                field.setLong(instance, value.getAsLong());
            }else if(fieldType.isAssignableFrom(Collection.class) && value.isAdaptableCollection()){
                ParameterizedType parameterizedType = (ParameterizedType) field.getGenericType();
                Class<?> type = (Class<?>) parameterizedType.getActualTypeArguments()[0];
                value.getListAdapter().setListContentType(type);
                field.set(instance, value.getAsAdaptedList(value.getListAdapter()));
            }else if(fieldType.equals(String.class)){
               field.set(instance, value.getAsString());
            }else{
                if(value.isComplexObject() && value.getComplexObjectAdapter() != null){
                    value.getComplexObjectAdapter().setComplexObjectType(fieldType);
                    field.set(instance, value.getAsComplexObject(value.getComplexObjectAdapter()));
                }else{
                    field.set(instance, value.getObject());
                }
            }
            return true;
        }catch (Exception ex){
            return false;
        }
    }
}
