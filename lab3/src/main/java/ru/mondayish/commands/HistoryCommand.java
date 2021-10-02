package ru.mondayish.commands;

import ru.mondayish.managers.ShotManager;
import ru.mondayish.utils.MessageUtils;
import ru.mondayish.utils.NumberUtils;

public class HistoryCommand implements Command {

    private static final String COMMAND_NAME = "commands.history.name";
    private static final String COMMAND_DESCRIPTION = "commands.history.description";
    private static final String COMMAND_MESSAGE1 = "commands.history.message1";
    private static final String COMMAND_MESSAGE2 = "commands.history.message2";

    private static final int DEFAULT_N_VALUE = 10;

    @Override
    public void execute(String args, ShotManager shotManager) {
        String strNum = args.trim();
        int n = NumberUtils.isInteger(strNum) ? Integer.parseInt(strNum) : DEFAULT_N_VALUE;
        System.out.println(MessageUtils.getMessage(COMMAND_MESSAGE1) + n + MessageUtils.getMessage(COMMAND_MESSAGE2));
        shotManager.getShots(n).forEach(s -> System.out.println(s.toString()));
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
