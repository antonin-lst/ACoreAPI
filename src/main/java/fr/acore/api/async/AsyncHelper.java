package fr.acore.api.async;

import fr.acore.api.os.SystemHelper;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public interface AsyncHelper extends SystemHelper {

    public static ExecutorService executorService = Executors.newFixedThreadPool(SystemHelper.getAvailableProcessorsStatic() / 2);

    public default <T> Future<T> submit(Callable<T> callable){
        return executorService.submit(callable);
    }

    public default void execute(Runnable runnable){
        executorService.execute(runnable);
    }

}
