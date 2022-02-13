package fr.acore.api.command;

public interface ICommandExecutor {

    public ICommandFactory getCommandFactory();


    public ICommandStatus<?> prePerformCommand(ICommandSender sender, String command);
    public ICommandPreform getArgumentToCommand(ICommand<?> commandRoot, String[] args);
}
