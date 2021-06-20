package ru.mondayish.model;

public class Shot {

    private final double x;
    private final double y;
    private final double r;
    private final boolean result;

    public Shot(double x, double y, double r, boolean result) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.result = result;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getR() {
        return r;
    }

    public boolean isResult() {
        return result;
    }

    @Override
    public String toString() {
        return "Shot : " +
                "x = " + x +
                ", y = " + y +
                ", r = " + r +
                ", result = " + result;
    }
}
