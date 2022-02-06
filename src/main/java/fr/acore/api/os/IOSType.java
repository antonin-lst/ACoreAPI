package fr.acore.api.os;

import fr.acore.api.os.process.factory.IExternalProcessFactory;

import java.util.List;

public interface IOSType {

    public List<String> getTags();
    public IExternalProcessFactory getProcessFactory();


    public static String getCurrentOsName(){
        return System.getProperty("os.name");
    }

}
