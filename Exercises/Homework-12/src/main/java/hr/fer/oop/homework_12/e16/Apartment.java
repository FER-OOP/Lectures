package hr.fer.oop.homework_12.e16;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;

/**
 *
 * @author Krešimir Pripužić <kresimir.pripuzic@fer.hr>
 */
public class Apartment {

    private Collection<Room> rooms;
    private String address;
    private int floor;

    public static final Comparator<Apartment> BY_ADDRESS = (a1, a2) -> a1.address.compareTo(a2.address);
    public static final Comparator<Apartment> BY_FLOOR = (a1, a2) -> Integer.compare(a1.floor, a2.floor);
    public static final Comparator<Apartment> BY_AREA = (a1, a2) -> a1.getArea().compareTo(a2.getArea());
    public static final Comparator<Apartment> BY_NUMBER_OF_ROOMS = (a1, a2) -> Integer.compare(a1.rooms.size(), a2.rooms.size());

    public Apartment(String address, int floor) {
        this.rooms = new HashSet<>();
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

    public String getAddress() {
        return address;
    }

    public int getFloor() {
        return floor;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(this.rooms, this.address, this.floor);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Apartment other = (Apartment) obj;
        if (this.floor != other.floor) {
            return false;
        }
        if (!Objects.equals(this.address, other.address)) {
            return false;
        }
        return Objects.equals(this.rooms, other.rooms);
    }

    @Override
    public String toString() {
        return "Apartment{" + "area=" + getArea() + ", numberOfRooms=" + rooms.size() + ", floor=" + floor + '}';
    }
    
    
}
