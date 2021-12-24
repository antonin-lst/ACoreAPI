package fr.acore.api.copy;

/*

Interface de Processuse de copy

 */

public interface ICopyProcess<T> {

    /*

    Copy simple

     */

    public static interface IBasicCopyProcess<T> extends ICopyProcess<T>{

        public T copy(T ac);

    }

    /*

    Copy revmap

     */

    public static interface ICopyRevMapProcess<T, V> extends ICopyProcess<T>{


        public T copy(V complex);

    }


    /*

    Copy complex

     */

    public static interface IComplexCopyProcess<T, U, V> extends ICopyProcess<T>{

        public T copy(T ac, U complex1, V complex2);

    }
}
