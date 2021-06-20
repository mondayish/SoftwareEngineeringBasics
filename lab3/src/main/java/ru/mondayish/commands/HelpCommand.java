package ru.mondayish.commands;

import ru.mondayish.managers.ShotManager;

import java.util.List;

public class HelpCommand implements Command {

    @Override
    public void execute(String args, ShotManager shotManager) {
        List<Command> availableCommands = shotManager.getAvailableCommands();
        System.out.println("Available commands:");
        availableCommands.forEach(c -> System.out.println(c.getDescription()));
    }

    @Override
    public String getName() {
        return "help";
    }

    @Override
    public String getDescription() {
        return "help : Prints available commands";
    }
}
