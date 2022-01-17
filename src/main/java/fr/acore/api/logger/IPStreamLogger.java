package fr.acore.api.logger;

import fr.acore.api.logger.log.ILog;
import fr.acore.api.logger.transformer.ILogTransformer;

import java.io.PrintStream;

/*

Interface de Log avec un PrintStream

 */

public interface IPStreamLogger<T extends PrintStream, U extends ILog> extends IBaseLogger<U, ILogTransformer<U>>{

    public T getPStream();
    public void setPStream(T stream);


}
