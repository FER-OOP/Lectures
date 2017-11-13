package hr.fer.oop.practice.z2_generics;

/**
 *
 * @author Krešimir Pripužić <kresimir.pripuzic@fer.hr>
 */
public interface SensorReading {
    
    String getMeasurementType();
    String getMeasurmentUnit();
    Object getReadingValue();
}
