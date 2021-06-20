package ru.mondayish.model;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

public class History {

    private final List<Shot> shots = new LinkedList<>();

    public Stream<Shot> getShotsStream() {
        return shots.stream();
    }

    public void addShot(Shot shot) {
        shots.add(shot);
    }
}
