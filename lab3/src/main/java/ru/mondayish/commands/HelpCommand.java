package ru.mondayish.commands;

import ru.mondayish.managers.ShotManager;
import ru.mondayish.utils.MessageUtils;

import java.util.List;

public class HelpCommand implements Command {

    private static final String COMMAND_NAME = "commands.help.name";
    private static final String COMMAND_DESCRIPTION = "commands.help.description";
    private static final String COMMAND_MESSAGE = "commands.help.message";

    @Override
    public void execute(String args, ShotManager shotManager) {
        List<Command> availableCommands = shotManager.getAvailableCommands();
        System.out.println(MessageUtils.getMessage(COMMAND_MESSAGE));
        availableCommands.forEach(c -> System.out.println(c.getDescription()));
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
