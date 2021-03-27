package hr.fer.oop.homework_05.e08;

public class DigitalItem extends LibraryItem {
	private String type;

	public DigitalItem(int id, String name, String type) {
		super(id, name);
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return super.toString() + ", type=" + type;
	}
	
}
