package ru.mondayish.commands;

import ru.mondayish.managers.ShotManager;
import ru.mondayish.model.Shot;
import ru.mondayish.utils.AreaUtils;
import ru.mondayish.utils.NumberUtils;

public class ShotCommand implements Command {

    @Override
    public void execute(String args, ShotManager shotManager) {
        String[] commandArgs =  args.trim().split(" ");
        if(!NumberUtils.isDouble(commandArgs[0]) || !NumberUtils.isDouble(commandArgs[1]) || !NumberUtils.isDouble(commandArgs[2])){
            System.err.println("Invalid arguments for command");
            return;
        }
        double x = Double.parseDouble(commandArgs[0]);
        double y = Double.parseDouble(commandArgs[1]);
        double r = Double.parseDouble(commandArgs[2]);
        boolean result = AreaUtils.getResultOfShot(x, y, r);
        System.out.println("Result: "+result);
        shotManager.addShotToHistory(new Shot(x, y, r, result));
    }

    @Override
    public String getName() {
        return "shot";
    }

    @Override
    public String getDescription() {
        return "shot x y r : Check that point is in area";
    }
}
