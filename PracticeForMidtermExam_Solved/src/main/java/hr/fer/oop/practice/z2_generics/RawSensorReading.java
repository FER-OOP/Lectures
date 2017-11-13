package hr.fer.oop.practice.z2_generics;

/**
 *
 * @author Krešimir Pripužić <kresimir.pripuzic@fer.hr>
 */
public class RawSensorReading implements SensorReading {

    private String measurementType;
    private String measurmentUnit;
    private String readingType;
    private String readingValue;

    public RawSensorReading(String measurementType, String measurmentUnit, String readingType, String readingValue) {
        this.measurementType = measurementType;
        this.measurmentUnit = measurmentUnit;
        this.readingType = readingType;
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

    public String getReadingType() {
        return readingType;
    }

    @Override
    public String getReadingValue() {
        return readingValue;
    }
}
