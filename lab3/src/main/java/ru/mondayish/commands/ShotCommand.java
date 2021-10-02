package ru.mondayish.commands;

import ru.mondayish.managers.ShotManager;
import ru.mondayish.model.Shot;
import ru.mondayish.utils.AreaUtils;
import ru.mondayish.utils.MessageUtils;
import ru.mondayish.utils.NumberUtils;

public class ShotCommand implements Command {

    private static final String COMMAND_NAME = "commands.shot.name";
    private static final String COMMAND_DESCRIPTION = "commands.shot.description";
    private static final String COMMAND_ERROR = "commands.shot.error";
    private static final String COMMAND_RESULT = "commands.shot.result";

    @Override
    public void execute(String args, ShotManager shotManager) {
        String[] commandArgs = args.trim().split(" ");
        if (!NumberUtils.isDouble(commandArgs[0]) || !NumberUtils.isDouble(commandArgs[1]) || !NumberUtils.isDouble(commandArgs[2])) {
            System.err.println(MessageUtils.getMessage(COMMAND_ERROR));
            return;
        }
        try {
            double x = Double.parseDouble(commandArgs[0]);
            double y = Double.parseDouble(commandArgs[1]);
            double r = Double.parseDouble(commandArgs[2]);
            boolean result = AreaUtils.getResultOfShot(x, y, r);
            System.out.println(MessageUtils.getMessage(COMMAND_RESULT) + result);
            shotManager.addShotToHistory(new Shot(x, y, r, result));
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
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
