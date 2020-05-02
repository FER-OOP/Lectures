package hr.fer.oop.zad3;

import java.util.Comparator;
import java.util.Objects;

public class Bicycle {

    private String brand;
    private double price;
    private Person owner;

    public Bicycle(String brand, double price, Person owner) {
        this.brand = brand;
        this.price = price;
        this.owner = owner;
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, price, owner);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Bicycle)) {
            return false;
        }

        Bicycle other = (Bicycle) obj;

        return (Objects.equals(brand, other.brand)
                && Objects.equals(price, other.price)
                && Objects.equals(owner, other.owner));
    }
    
    @Override
    public String toString() {
        return "Bicycle{" + "brand=" + brand + ", price=" + price + ", owner=" + owner + '}';
    }

    public static final Comparator<Bicycle> BY_BRAND = (a, b) -> a.brand.compareTo(b.brand);
    public static final Comparator<Bicycle> BY_PRICE = (a, b) -> Double.compare(a.price, b.price);
    public static final Comparator<Bicycle> BY_OWNER = (a, b) -> a.owner.compareTo(b.owner);
}
