package fr.acore.api.command;

import java.util.Map;

public interface ICommandFactory {

    public Map<ICommand<?>, ICommandExecutor> getRegisteredCommands();
    public void registerCommand(ICommand<?> command, ICommandExecutor executor);
    public void removeCommand(ICommand<?> command);
    public void removeAllCommandFromExecutor(ICommandExecutor executor);

    public ICommandExecutor getCommandExecutor(ICommand<?> command);

    public default ICommandExecutor getCommandExecutor(String command){
        return getCommandExecutor(getRootCommand(command));
    }

    public default ICommand<?> getRootCommand(String command){
        if(getRootCommandByName(command) != null) return getRootCommandByName(command);
        if(getRootCommandByAliases(command) != null) return getRootCommandByAliases(command);
        return null;
    }

    public default ICommand<?> getRootCommandByName(String command) {
        if(command.startsWith("/")) command = command.replaceFirst("/", "");
        String commandRoot = command.contains(" ") ? command.split(" ")[0] : command;

        for(ICommand<?> registeredCmd : getRegisteredCommands().keySet()) {
            if(registeredCmd.getName().equalsIgnoreCase(commandRoot)) return registeredCmd;
        }
        return null;
    }

    public default ICommand<?> getRootCommandByAliases(String command){
        if(command.startsWith("/")) command = command.replaceFirst("/", "");
        String commandRoot = command.contains(" ") ? command.split(" ")[0] : command;

        for(ICommand<?> registeredCmd : getRegisteredCommands().keySet()) {
            for(String aliases : registeredCmd.getAliases())
                if(aliases.equalsIgnoreCase(commandRoot)) return registeredCmd;
        }
        return null;
    }
}
