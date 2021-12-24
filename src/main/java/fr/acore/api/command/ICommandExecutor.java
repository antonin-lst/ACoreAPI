package fr.acore.api.command;

public interface ICommandExecutor {

    public ICommandFactory getCommandFactory();

    public ICommandPreform getArgumentToCommand(ICommand<?> commandRoot, String[] args);
}
