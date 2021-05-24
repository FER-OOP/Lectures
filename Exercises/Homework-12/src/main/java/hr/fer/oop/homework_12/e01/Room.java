package hr.fer.oop.homework_12.e01;

import java.awt.Color;

/**
 *
 * @author Krešimir Pripužić <kresimir.pripuzic@fer.hr>
 */
public class Room {
    private FloorType floorType;
    private double area;
    private boolean heated;
    private int numberOfWindows;
    private Color wallColor;

    public Room(FloorType floorType, double area, boolean heated, int numberOfWindows, Color wallColor) {
        this.floorType = floorType;
        this.area = area;
        this.heated = heated;
        this.numberOfWindows = numberOfWindows;
        this.wallColor = wallColor;
    }        

    public FloorType getFloorType() {
        return floorType;
    }

    public double getArea() {
        return area;
    }

    public boolean isHeated() {
        return heated;
    }

    public int getNumberOfWindows() {
        return numberOfWindows;
    }

    public Color getWallColor() {
        return wallColor;
    }      
}
