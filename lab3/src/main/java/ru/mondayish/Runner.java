package ru.mondayish;

import ru.mondayish.managers.ConsoleManager;

public class Runner {
    public static void main(String[] args) {
        System.out.println("revision");
        new ConsoleManager().run();
    }
}
