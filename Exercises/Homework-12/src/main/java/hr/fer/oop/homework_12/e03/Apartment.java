package hr.fer.oop.homework_12.e03;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

/**
 *
 * @author Krešimir Pripužić <kresimir.pripuzic@fer.hr>
 */
public class Apartment {

    private Collection<Room> rooms;
    private String address;
    private int floor;

    public Apartment(String address, int floor) {
        rooms = new HashSet<>();
        this.address = address;
        this.floor = floor;
    }

    public void addRooms(Room... rooms) {
        for (Room room : rooms) {
            this.rooms.add(room);
        }
    }

    public void removeRooms(Room... rooms) {
        for (Room room : rooms) {
            this.rooms.remove(room);
        }
    }

    public boolean containsRoom(Room room) {
        return rooms.contains(room);
    }

    public Iterator<Room> roomIterator() {
        return rooms.iterator();
    }

    public double getArea() {
        double area = 0;

        for (Room room : rooms) {
            area += room.getArea();
        }

        return area;
    }

    public String getAddress() {
        return address;
    }

    public int getFloor() {
        return floor;
    }
}
