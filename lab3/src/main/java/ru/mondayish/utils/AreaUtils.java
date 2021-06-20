package ru.mondayish.utils;

public class AreaUtils {

    public static boolean getResultOfShot(double x, double y, double r){
        return isInRightTop(x,y,r) || isInRightBottom(x,y,r)
                || isInLeftTop(x,y,r) || isInLeftBottom(x,y,r);
    }

    public static boolean isInRightTop(double x, double y, double r){
        return x >= 0 && y >= 0 && x <= r && y <= r / 2;
    }

    public static boolean isInLeftTop(double x, double y, double r){
        return false;
    }

    public static boolean isInRightBottom(double x, double y, double r){
        return x >= 0 && y <= 0 && r * r / 4 >= x * x + y * y;
    }

    public static boolean isInLeftBottom(double x, double y, double r){
        return x <= 0 && y <= 0 && y >= -x / 2 - r / 2;
    }
}
