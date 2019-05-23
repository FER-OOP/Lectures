package hr.fer.oop.zad2;

public class Sweet {
	private String name;
	private double weight;
	private double price;
	private int sweetness;
	
	public Sweet(String name, double weight, double price, int sweetness) {
		super();
		this.name = name;
		this.weight = weight;
		this.price = price;
		this.sweetness = sweetness;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getWeight() {
		return weight;
	}
	
	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getSweetness() {
		return sweetness;
	}

	public void setSweetness(int sweetness) {
		this.sweetness = sweetness;
	}

	@Override
	public String toString() {
		return "Sweet [name=" + name + ", weight=" + weight + ", price=" + price + ", sweetness=" + sweetness + "]";
	}
	
	
	

}
