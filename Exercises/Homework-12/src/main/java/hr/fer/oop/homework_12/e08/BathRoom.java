package hr.fer.oop.homework_12.e08;

import hr.fer.oop.homework_12.e01.FloorType;
import java.awt.Color;
import java.math.BigDecimal;

/**
 *
 * @author Krešimir Pripužić <kresimir.pripuzic@fer.hr>
 */
public class BathRoom extends Room {
    private boolean hasBidet;
    private int numberOfSinks;
    private String bathtubType;

    public BathRoom(boolean hasBidet, int numberOfSinks, String bathtubType, FloorType floorType, BigDecimal area, boolean heated, int numberOfWindows, Color wallColor) {
        super(floorType, area, heated, numberOfWindows, wallColor);
        this.hasBidet = hasBidet;
        this.numberOfSinks = numberOfSinks;
        this.bathtubType = bathtubType;
    }

    public boolean hasBidet() {
        return hasBidet;
    }

    public int getNumberOfSinks() {
        return numberOfSinks;
    }

    public String getBathtubType() {
        return bathtubType;
    }
    
    
}
