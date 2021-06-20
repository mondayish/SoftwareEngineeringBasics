package ru.mondayish.managers;

import ru.mondayish.commands.*;
import ru.mondayish.model.History;
import ru.mondayish.model.Shot;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ShotManager {

    private final List<Command> availableCommands =
            Arrays.asList(new ExitCommand(), new HelpCommand(), new HistoryCommand(), new ShotCommand());
    private final History history = new History();

    public List<Command> getAvailableCommands() {
        return availableCommands;
    }

    public void addShotToHistory(Shot shot){
        history.addShot(shot);
    }

    public Stream<Shot> getShots(int limit){
        return history.getShotsStream().limit(limit);
    }
}
