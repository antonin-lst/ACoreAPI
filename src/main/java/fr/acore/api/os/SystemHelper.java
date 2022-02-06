package fr.acore.api.os;

import com.sun.management.OperatingSystemMXBean;
import fr.acore.api.os.impl.OSType;

import java.lang.management.ManagementFactory;

public interface SystemHelper {

     public static Runtime runtime = Runtime.getRuntime();
     public static int mb = 1024 * 1024;

    public default IOSType getCurrentOs(){
        return OSType.getOsType();
    }

    public default boolean runtimeSupported(){
        return runtime != null;
    }

    public default Architecture getCurrentArch(){
        return Architecture.getCurrentArch();
    }

    public default long getTotalRam() {
        if(runtimeSupported()) return runtime.totalMemory() / mb;
        return -1;
    }

    public default long getMaxMemory(){
        if(runtimeSupported()) return runtime.maxMemory() / mb;
        return -1;
    }

    public default long getFreeMemory(){
        if(runtimeSupported()) return runtime.freeMemory() / mb;
        return -1;
    }

    public default long getUsedMemory(){
        if(runtimeSupported()) return (runtime.totalMemory() - runtime.freeMemory()) / mb;
        return -1;
    }

    public default int getAvailableProcessors(){
        return runtime.availableProcessors();
    }

    public static int getAvailableProcessorsStatic(){
        return runtime.availableProcessors();
    }

    public default double getJavaVersion() {
        String version = System.getProperty("java.version");
        int count = 0;
        int pos;
        for (pos = 0; pos < version.length() && count < 2; pos++) {
            if (version.charAt(pos) == '.')
                count++;
        }
        pos--;
        String doubleVersion = version.substring(0, pos);
        return Double.parseDouble(doubleVersion);
    }

    public enum Architecture {
        X32, X64, UNKNOWN;

        private static Architecture getCurrentArch(){
            String curArch = System.getProperty("sun.arch.data.model");
            for (Architecture arch : values()) {
                if (arch.name().toLowerCase().equals(curArch))
                    return arch;
            }
            return UNKNOWN;
        }
    }
}
