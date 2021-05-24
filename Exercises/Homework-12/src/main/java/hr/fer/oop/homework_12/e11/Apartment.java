package hr.fer.oop.homework_12.e11;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;


/**
 *
 * @author Krešimir Pripužić <kresimir.pripuzic@fer.hr>
 */
public class Apartment {

    private Collection<Room> rooms;
    private String address;
    private int floor;

    public Apartment(String address, int floor) {
        rooms = new TreeSet<>(Comparator.comparing(Room::getNumberOfWindows));
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

    public BigDecimal getArea() {
        BigDecimal area = new BigDecimal(0);

        for (Room room : rooms) {
            area = area.add(room.getArea());
        }

        return area;
    }
}
