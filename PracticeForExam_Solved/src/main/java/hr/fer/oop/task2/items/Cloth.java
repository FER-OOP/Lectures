package hr.fer.oop.task2.items;

public class Cloth extends Item {

    private double size;

    public Cloth(String sku, String name, double size) {
        super(sku, name);
        this.size = size;
    }

    public Cloth(String sku, String name, double price, double size) {
        super(sku, name, price);
        this.size = size;
    }

    @Override
    public String getItemType() {
        return "Cloth";
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

}
