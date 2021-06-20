package ru.mondayish.commands;

import ru.mondayish.managers.ShotManager;
import ru.mondayish.utils.NumberUtils;

public class HistoryCommand implements Command {

    private static final int DEFAULT_N_VALUE = 10;

    @Override
    public void execute(String args, ShotManager shotManager) {
        String strNum = args.trim();
        int n = NumberUtils.isInteger(strNum) ? Integer.parseInt(strNum) : DEFAULT_N_VALUE;
        System.out.println("Last "+n+" shots:");
        shotManager.getShots(n).forEach(s -> System.out.println(s.toString()));
    }

    @Override
    public String getName() {
        return "history";
    }

    @Override
    public String getDescription() {
        return "history [n] : Prints last [n] or 10(default) shots";
    }
}
