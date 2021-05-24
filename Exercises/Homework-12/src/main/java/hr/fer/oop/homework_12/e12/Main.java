package hr.fer.oop.homework_12.e12;

import hr.fer.oop.homework_12.e01.FloorType;
import java.awt.Color;
import java.math.BigDecimal;
import java.util.Iterator;

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

        System.out.println("Added room found: " + apartment.containsRoom(bedRoom2));
        System.out.println("Identical room found: " + apartment.containsRoom(new Room(FloorType.HARDWOOD, new BigDecimal("17.33"), true, 2, Color.GREEN)));
        System.out.println("Almost identical room found: " + apartment.containsRoom(new Room(FloorType.HARDWOOD, new BigDecimal("18.01").subtract(new BigDecimal("0.68")), true, 2, Color.GREEN)));

        System.out.println("Identical bathroom found: " + apartment.containsRoom(new BathRoom(true, 1, "shower", FloorType.CERAMIC, new BigDecimal("7.28"), true, 0, Color.BLUE)));
        System.out.println("Different bathroom found: " + apartment.containsRoom(new BathRoom(false, 2, "bath", FloorType.CERAMIC, new BigDecimal("7.28"), true, 0, Color.BLUE)));

        int counter = 0;
        Iterator<Room> iterator = apartment.roomIterator();
        while (iterator.hasNext()) {
            iterator.next();
            counter++;
        }

        System.out.println("Number of rooms: " + counter);
    }
}
