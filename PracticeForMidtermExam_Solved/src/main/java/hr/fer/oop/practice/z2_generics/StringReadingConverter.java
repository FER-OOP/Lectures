package hr.fer.oop.practice.z2_generics;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Krešimir Pripužić <kresimir.pripuzic@fer.hr>
 */
public class StringReadingConverter {

    public static Collection<TypedSensorReading<String>> convert(Collection<RawSensorReading> readings) {
        List<TypedSensorReading<String>> result = new LinkedList<>();

        for (RawSensorReading reading : readings) {
            if (reading.getReadingType().equals("String")) {
                result.add(new TypedSensorReading<>(reading.getMeasurementType(),
                        reading.getMeasurmentUnit(),
                        reading.getReadingValue()));
            }
        }

        return result;
    }
}
