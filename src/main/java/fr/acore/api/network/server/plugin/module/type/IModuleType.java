package fr.acore.api.network.server.plugin.module.type;

public enum IModuleType {

    APPS("APPS"), MODULES("Modules"), APIS("APIS");

    private String type;

    IModuleType(String type){
        this.type = type;
    }

    public String getType() {
        return type;
    }
}