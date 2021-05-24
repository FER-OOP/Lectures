/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.fer.oop.homework_12.e15;

import hr.fer.oop.homework_12.e01.FloorType;
import java.awt.Color;
import java.math.BigDecimal;

/**
 *
 * @author Krešimir Pripužić <kresimir.pripuzic@fer.hr>
 */
public class ApartmentLoader {
    public static Apartment[] load() {
        Apartment[] apartments = new Apartment[5];
        
        //apartment 0
        Apartment apartment = new Apartment("Unska 2, 10000 Zagreb", 2);
        Room kitchen = new Room(FloorType.CERAMIC, new BigDecimal("8.56"), false, 1, Color.YELLOW);
        Room bathRoom = new BathRoom(true, 1, "shower", FloorType.CERAMIC, new BigDecimal("7.28"), true, 0, Color.BLUE);
        Room bedRoom1 = new Room(FloorType.HARDWOOD, new BigDecimal("12.23"), true, 1, Color.PINK);
        Room bedRoom2 = new Room(FloorType.HARDWOOD, new BigDecimal("17.33"), true, 2, Color.GREEN);
        Room livingRoom = new Room(FloorType.HARDWOOD, new BigDecimal("20.08"), true, 3, Color.ORANGE);
        apartment.addRooms(kitchen, bathRoom, bedRoom1, bedRoom2, livingRoom);
        apartments[0] = apartment;
        
        //apartment 1
        apartment = new Apartment("Zelinska 5, 10000 Zagreb", 1);
        kitchen = new Room(FloorType.LINOLEUM, new BigDecimal("7.76"), false, 1, Color.WHITE);
        bathRoom = new BathRoom(true, 1, "shower", FloorType.CERAMIC, new BigDecimal("7.28"), true, 0, Color.WHITE);
        bedRoom1 = new Room(FloorType.LAMINATE, new BigDecimal("15.25"), true, 1, Color.WHITE);
        livingRoom = new Room(FloorType.LAMINATE, new BigDecimal("18.18"), true, 3, Color.WHITE);
        apartment.addRooms(kitchen, bathRoom, bedRoom1, livingRoom);
        apartments[1] = apartment;
        
        //apartment 2
        apartment = new Apartment("Koturaška 43, 10000 Zagreb", 3);
        kitchen = new Room(FloorType.CERAMIC, new BigDecimal("9.78"), false, 1, Color.LIGHT_GRAY);
        bathRoom = new BathRoom(true, 1, "shower", FloorType.CERAMIC, new BigDecimal("7.28"), true, 0, Color.LIGHT_GRAY);
        bedRoom1 = new Room(FloorType.HARDWOOD, new BigDecimal("16.27"), true, 1, Color.LIGHT_GRAY);
        livingRoom = new Room(FloorType.HARDWOOD, new BigDecimal("18.12"), true, 3, Color.LIGHT_GRAY);
        apartment.addRooms(kitchen, bathRoom, bedRoom1, livingRoom);
        apartments[2] = apartment;
        
        //apartment 3
        apartment = new Apartment("Koranska 1, 10000 Zagreb", 4);
        kitchen = new Room(FloorType.CERAMIC, new BigDecimal("9.63"), false, 1, Color.WHITE);
        bathRoom = new BathRoom(true, 1, "shower", FloorType.CERAMIC, new BigDecimal("9.12"), true, 0, Color.WHITE);
        livingRoom = new Room(FloorType.CERAMIC, new BigDecimal("16.08"), true, 3, Color.WHITE);
        apartment.addRooms(kitchen, bathRoom, livingRoom);
        apartments[3] = apartment;
        
        //apartment 4
        apartment = new Apartment("Kupska 9, 10000 Zagreb", 0);
        kitchen = new Room(FloorType.LINOLEUM, new BigDecimal("15.26"), false, 1, Color.YELLOW);
        bathRoom = new BathRoom(true, 1, "bath", FloorType.CERAMIC, new BigDecimal("11.28"), true, 0, Color.YELLOW);
        bedRoom1 = new Room(FloorType.LAMINATE, new BigDecimal("25.26"), true, 1, Color.YELLOW);
        bedRoom2 = new Room(FloorType.LAMINATE, new BigDecimal("22.45"), true, 2, Color.YELLOW);
        Room bedRoom3 = new Room(FloorType.LAMINATE, new BigDecimal("16.82"), true, 2, Color.YELLOW);
        livingRoom = new Room(FloorType.STONE, new BigDecimal("30.11"), true, 3, Color.YELLOW);
        apartment.addRooms(kitchen, bathRoom, bedRoom1, bedRoom2, bedRoom3, livingRoom);
        apartments[4] = apartment;
                
        return apartments;
    }
}
