package org.example.jdk.demo.finalclass;

/**
 * @description: //TODO
 * @author: lvxuhong
 * @date: 2021/6/3
 */
public final class Location {

    private final double x;

    private final double y;

    public Location(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }


    public double getY() {
        return y;
    }

}
