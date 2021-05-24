package hr.fer.oop.homework_12.e13;

import hr.fer.oop.homework_12.e01.FloorType;
import java.awt.Color;
import java.math.BigDecimal;
import java.util.Objects;

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

    @Override
    public int hashCode() {
        //be careful since the superclass has to correctly implement hashCode
        return Objects.hash(this.bathtubType, this.hasBidet, this.numberOfSinks, super.hashCode());
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

        //be careful since the superclass has to correctly implement hashCode
        if (!super.equals(obj)) {
            return false;
        }

        final BathRoom other = (BathRoom) obj;
        if (this.hasBidet != other.hasBidet) {
            return false;
        }
        if (this.numberOfSinks != other.numberOfSinks) {
            return false;
        }
        if (!Objects.equals(this.bathtubType, other.bathtubType)) {
            return false;
        }
        return true;
    }    
}
