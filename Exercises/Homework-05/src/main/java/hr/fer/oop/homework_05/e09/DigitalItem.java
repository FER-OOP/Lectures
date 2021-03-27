package hr.fer.oop.homework_05.e09;

public class DigitalItem extends LibraryItem implements ItemWithCashDepozit {
	private String type;
	private double cashDepozitAmmount;

	public DigitalItem(int id, String name, String type, double cashDepozitAmmount) {
		super(id, name);
		this.type = type;
		this.cashDepozitAmmount = cashDepozitAmmount;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public double getCashDepozitAmmount() {
		return cashDepozitAmmount;
	}

	public void setCashDepozitAmmount(double cashDepozitAmmount) {
		this.cashDepozitAmmount = cashDepozitAmmount;
	}

	@Override
	public String toString() {
		return super.toString() + ", type=" + type;
	}
	
	@Override
	public int getLoanPeriod() {
		return 30;
	}
	
}