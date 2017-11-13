package hr.fer.oop.practice.z2_generics;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Krešimir Pripužić <kresimir.pripuzic@fer.hr>
 */
public class NumberReadingConverter {

    public static Collection<TypedSensorReading<Number>> convert(Collection<RawSensorReading> readings) {
        List<TypedSensorReading<Number>> result = new LinkedList<>();

        for (RawSensorReading reading : readings) {
            try {
                result.add(new TypedSensorReading<>(reading.getMeasurementType(),
                        reading.getMeasurmentUnit(),
                        NumberFormat.getInstance().parse(reading.getReadingValue())));
            } catch (ParseException ex) {
                //ignore
            }
        }

        return result;
    }
}
