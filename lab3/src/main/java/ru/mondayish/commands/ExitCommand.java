package ru.mondayish.commands;

import ru.mondayish.managers.ShotManager;
import ru.mondayish.utils.MessageUtils;

public class ExitCommand implements Command {

    private static final String COMMAND_NAME = "commands.exit.name";
    private static final String COMMAND_DESCRIPTION = "commands.exit.description";
    private static final String COMMAND_MESSAGE = "commands.exit.message";

    @Override
    public void execute(String args, ShotManager shotManager) {
        System.out.println(MessageUtils.getMessage(COMMAND_MESSAGE));
        System.exit(0);
    }

    @Override
    public String getName() {
        return MessageUtils.getMessage(COMMAND_NAME);
    }

    @Override
    public String getDescription() {
        return MessageUtils.getMessage(COMMAND_DESCRIPTION);
    }
}
