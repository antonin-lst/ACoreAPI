package fr.acore.api.command;

import java.util.List;

public interface ICommand<T extends ICommandSender> {

    public String getName();
    public List<String> getAliases();
    public void addAliases(String... aliases);
    public List<ICommand<?>> getArguments();
    public void setArguments(List<ICommand<?>> arguments);

    public ICommandStatus prePerformCommand(T sender, String... args);

    public String getPermission();
    public String getSyntax();

}
