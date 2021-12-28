package fr.acore.api.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public interface ListHelper {



    //ajoute un element a une list a la place de l'index
    // {1,4,5,6}, 3, 1 -> {1,3,4,5,6}
    // throw IndexOutOfBoundsException | UnsupportedException
    public default <T> List<T> addBefore(List<T> array, T element, int index){
        List<T> result = new ArrayList<>();

        if(index > 0){
            result.addAll(array.subList(0, index));
        }
        result.add(element);
        if(index < array.size()) result.addAll(array.subList(index, array.size()));
        return result;
    }

    //ajoute un element a une list apres un index
    // {1,4,5,6}, 3, 1 -> {1,4,3,5,6}
    // throw IndexOutOfBoundsException | UnsupportedException
    public default <T> List<T> addAfter(List<T> array, T element, int index){
        List<T> result = new ArrayList<>();

        result.addAll(array.subList(0, ++index));
        result.add(element);
        result.addAll(array.subList(index, array.size()));
        return result;
    }

    public default List<String> convertToListedString(Object... args){
        return convertToListedString(new ArrayList<>(), args);
    }

    public default List<String> convertToListedString(List<String> origin, Object... args){
        Arrays.stream(args).forEach((arg) -> origin.add(arg.toString()));
        return origin;
    }

}
