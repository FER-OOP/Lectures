package hr.fer.oop.practice.z2_generics;

import java.util.Collection;
import java.util.LinkedList;

/**
 *
 * @author Krešimir Pripužić <kresimir.pripuzic@fer.hr>
 */
public class Main {
    public static void main(String[] args) {
        
        Collection<RawSensorReading> readings = new LinkedList<>();
        
        readings.add(new RawSensorReading("temperature", "C", "Double", "24.25"));
        readings.add(new RawSensorReading("humidity", "%", "Float", "57.36"));
        readings.add(new RawSensorReading("steps", "", "Integer", "244234"));
        readings.add(new RawSensorReading("depth", "m", "Short", "4576"));
        readings.add(new RawSensorReading("trafficAlert", "", "String", "Accident on A41 Watford Way Southbound at A1 Great North Way."));
        
        Collection<TypedSensorReading<Number>> numberReadings = NumberReadingConverter.convert(readings);   
        Collection<TypedSensorReading<String>> stringReadings = StringReadingConverter.convert(readings);   

        System.out.println(numberReadings.size()); //ispisuje 4
        System.out.println(stringReadings.size()); //ispisuje 1
        
        //ispisuje "Accident on A41 Watford Way Southbound at A1 Great North Way."
        for (SensorReading reading:stringReadings) {
            System.out.println(reading.getReadingValue());
        }
    }
}
