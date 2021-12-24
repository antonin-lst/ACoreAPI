package fr.acore.api.command;

import java.util.Map;

public interface ICommandFactory {

    public Map<ICommand<?>, ICommandExecutor> getRegisteredCommands();
    public void registerCommand(ICommand<?> command, ICommandExecutor executor);
    public void removeCommand(ICommand<?> command);
    public void removeAllCommandFromExecutor(ICommandExecutor executor);

    public ICommandExecutor getCommandExecutor(ICommand<?> command);
}
