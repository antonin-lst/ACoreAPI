package fr.acore.api.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public interface ReflectionHelper {

    /*
     * Methode Reflection
     *
     */

    public default Method getMethod(Object obj, String name) throws Exception{
        Method method = obj.getClass().getDeclaredMethod(name);
        if(!method.isAccessible()) method.setAccessible(true);

        return method;
    }

    public default Method getMethod(Object obj, String name, Class<?>... clazz) throws Exception{
        Method method = obj.getClass().getDeclaredMethod(name, clazz);
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

    public default boolean injectField(Field field, Object instance, Object value) throws IllegalAccessException {
        try{
            if(!field.isAccessible()) field.setAccessible(true);

            Class<?> fieldType = field.getType();
            String serializedValue = String.valueOf(value);

            if(fieldType.equals(int.class) || fieldType.equals(Integer.class)){
                field.setInt(instance, Integer.parseInt(serializedValue));
            }else if(fieldType.equals(double.class) || fieldType.equals(Double.class)){
                field.setDouble(instance, Double.parseDouble(serializedValue));
            }else if(fieldType.equals(float.class) || fieldType.equals(Float.class)){
                field.setFloat(instance, Float.parseFloat(serializedValue));
            }else if(fieldType.equals(boolean.class) || fieldType.equals(Boolean.class)){
                field.setBoolean(instance, Boolean.parseBoolean(serializedValue));
            }else if(fieldType.equals(long.class) || fieldType.equals(Long.class)){
                field.setLong(instance, Long.parseLong(serializedValue));
            }else{
                field.set(instance, value);
            }
            return true;

        }catch (Exception ex){
            return false;
        }

    }

}
