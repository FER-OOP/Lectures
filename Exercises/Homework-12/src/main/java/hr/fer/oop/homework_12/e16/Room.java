package hr.fer.oop.homework_12.e16;

import hr.fer.oop.homework_12.e01.FloorType;
import java.awt.Color;
import java.math.BigDecimal;
import java.util.Comparator;
import java.util.Objects;

/**
 *
 * @author Krešimir Pripužić <kresimir.pripuzic@fer.hr>
 */
public class Room {

    private FloorType floorType;
    private BigDecimal area;
    private boolean heated;
    private int numberOfWindows;
    private Color wallColor;
    
    public Room(FloorType floorType, BigDecimal area, boolean heated, int numberOfWindows, Color wallColor) {
        this.floorType = floorType;
        this.area = area;
        this.heated = heated;
        this.numberOfWindows = numberOfWindows;
        this.wallColor = wallColor;
    }

    public FloorType getFloorType() {
        return floorType;
    }

    public BigDecimal getArea() {
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
    
    public int getWallColorAsRgb() {
        return wallColor.getRGB();
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.floorType, this.area, this.heated, this.numberOfWindows, this.wallColor);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Room other = (Room) obj;
        if (this.heated != other.heated) {
            return false;
        }
        if (this.numberOfWindows != other.numberOfWindows) {
            return false;
        }
        if (this.floorType != other.floorType) {
            return false;
        }
        if (!Objects.equals(this.area, other.area)) {
            return false;
        }
        if (!Objects.equals(this.wallColor, other.wallColor)) {
            return false;
        }
        return true;
    }
}
