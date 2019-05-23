package hr.fer.oop.zad3;

import java.util.Comparator;

public class Bicycle implements Comparable<Bicycle> {
	
	private String id;
	private String brand;
	private float price;
	private Person owner;
	
	public Bicycle(String id, String brand, float price, Person owner) {
		this.id = id;
		this.brand = brand;
		this.price = price;
		this.owner = owner;
	}
	
	@Override
    public int hashCode() {
        return ((this.id == null) ? 0 : id.hashCode());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Bicycle) {
            Bicycle bicycle = (Bicycle) obj;
            return (this.id == null) ? false : (this.id.compareTo(bicycle.id) == 0);
        } else {
            return false;
        }
    }

	@Override
	public int compareTo(Bicycle o) {
		return this.getId().compareTo(o.getId());
	}
	
	public static final Comparator<Bicycle> BY_BRAND = (a, b) -> a.getBrand().compareTo(b.getBrand());
    public static final Comparator<Bicycle> BY_ID = (a, b) -> a.getId().compareTo(b.getId());
    public static final Comparator<Bicycle> BY_PRICE = (a, b) -> Float.compare(a.getPrice(), b.getPrice());
    public static final Comparator<Bicycle> BY_OWNER = (a, b) -> a.getOwner().compareTo(b.getOwner());


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Person getOwner() {
		return owner;
	}

	public void setOwner(Person owner) {
		this.owner = owner;
	}

	@Override
	public String toString() {
		return "Bicycle [id=" + id + ", brand=" + brand + ", price=" + price + ", owner=" + owner + "]";
	}
	
}
