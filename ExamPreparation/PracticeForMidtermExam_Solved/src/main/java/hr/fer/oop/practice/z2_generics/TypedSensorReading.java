package hr.fer.oop.practice.z2_generics;

/**
 *
 * @author Krešimir Pripužić <kresimir.pripuzic@fer.hr>
 */
public class TypedSensorReading<T> implements SensorReading {
    private String measurementType;
    private String measurmentUnit;
    private T readingValue;

    public TypedSensorReading(String measurementType, String measurmentUnit, T readingValue) {
        this.measurementType = measurementType;
        this.measurmentUnit = measurmentUnit;
        this.readingValue = readingValue;
    }

    @Override
    public String getMeasurementType() {
        return measurementType;
    }

    @Override
    public String getMeasurmentUnit() {
        return measurmentUnit;
    }

    @Override
    public T getReadingValue() {
        return readingValue;
    }
}
