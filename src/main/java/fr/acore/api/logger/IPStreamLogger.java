package fr.acore.api.logger;

import java.io.PrintStream;

/*

Interface de Log avec un PrintStream

 */

public interface IPStreamLogger<T extends PrintStream> extends IBaseLogger{

    public T getPStream();
    public void setPStream(T stream);


}
