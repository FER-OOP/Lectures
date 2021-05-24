package hr.fer.oop.homework_12.e16;

import hr.fer.oop.homework_12.e01.FloorType;
import java.awt.Color;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Krešimir Pripužić <kresimir.pripuzic@fer.hr>
 */
public class Main {

    public static void main(String[] args) {
        Apartment apartment = new Apartment("Unska 2, 10000 Zagreb", 2);

        Room kitchen = new Room(FloorType.CERAMIC, new BigDecimal("8.56"), false, 1, Color.YELLOW);
        Room bathRoom = new BathRoom(true, 1, "shower", FloorType.CERAMIC, new BigDecimal("7.28"), true, 0, Color.BLUE);
        Room bedRoom1 = new Room(FloorType.HARDWOOD, new BigDecimal("12.23"), true, 1, Color.PINK);
        Room bedRoom2 = new Room(FloorType.HARDWOOD, new BigDecimal("17.33"), true, 2, Color.GREEN);
        Room livingRoom = new Room(FloorType.HARDWOOD, new BigDecimal("20.08"), true, 3, Color.ORANGE);

        apartment.addRooms(kitchen, bathRoom, bedRoom1, bedRoom2, livingRoom);

        Apartment[] apartments = ApartmentLoader.load();
        List<Apartment> listOfApartments = Arrays.asList(apartments);

        System.out.println("Added apartment found: " + listOfApartments.contains(apartments[0]));
        System.out.println("Identical apartment found: " + listOfApartments.contains(apartment));
        System.out.println("Are these apartments identical? " + apartments[0].equals(apartment));

        Set<Apartment> sortedApartments = new TreeSet<>(Apartment.BY_NUMBER_OF_ROOMS.reversed().
                thenComparing(Apartment.BY_FLOOR).
                thenComparing(Apartment.BY_AREA.reversed()));
        
        sortedApartments.addAll(listOfApartments);        
        sortedApartments.forEach(a -> System.out.println(a));
    }
}
