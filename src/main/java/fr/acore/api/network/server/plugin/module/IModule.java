package fr.acore.api.network.server.plugin.module;

import fr.acore.api.network.server.plugin.module.type.IModuleType;

public interface IModule {

    public int getId();
    public String getName();
    public IModuleType getType();
    public int getOwner();
    public String getGithubWorkspace();
    public String getPublicKey();
    public double getPrice();
    public String getDescription();
}
