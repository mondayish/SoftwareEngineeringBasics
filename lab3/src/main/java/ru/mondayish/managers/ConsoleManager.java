package ru.mondayish.managers;

import ru.mondayish.commands.Command;

import java.util.*;

public class ConsoleManager {

    private final ShotManager shotManager = new ShotManager();

    public void run(){
        Scanner scanner = new Scanner(System.in);
        while (true){
            String nextLine = scanner.nextLine();
            List<String> commandArgs = new ArrayList<>(Arrays.asList(nextLine.trim().split(" ")));
            String command = commandArgs.get(0);
            commandArgs.remove(0);
            String args = String.join(" ", commandArgs);

            Optional<Command> optCommand = findCommand(command);
            if (optCommand.isPresent())  optCommand.get().execute(args, shotManager);
            else System.err.println("Command not found, write help for commands");
        }
    }

    private Optional<Command> findCommand(String command) {
        return shotManager.getAvailableCommands().stream().filter(c -> c.getName().equals(command)).findAny();
    }
}
