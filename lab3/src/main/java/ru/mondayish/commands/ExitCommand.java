package ru.mondayish.commands;

import ru.mondayish.managers.ShotManager;

public class ExitCommand implements Command {

    @Override
    public void execute(String args, ShotManager shotManager) {
        System.out.println("Bye...");
        System.exit(0);
    }

    @Override
    public String getName() {
        return "exit";
    }

    @Override
    public String getDescription() {
        return "exit : Ends the program";
    }
}
