package fr.acore.api.command;

public interface ICommandSender {

    public boolean hasPermission(String... perm);

}
