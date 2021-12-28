package fr.acore.api.command;

public interface ICommandStatus<T extends Enum<T>>
{
    public T getCommandStatus();
}
