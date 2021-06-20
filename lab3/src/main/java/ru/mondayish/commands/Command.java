package ru.mondayish.commands;

import ru.mondayish.managers.ShotManager;

public interface Command {

    void execute(String args, ShotManager shotManager);

    String getName();

    String getDescription();
}
