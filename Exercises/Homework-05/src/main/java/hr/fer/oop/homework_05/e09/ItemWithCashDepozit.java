package hr.fer.oop.homework_05.e09;

public interface ItemWithCashDepozit {
	
	public default boolean hasCashDeposit() {
		return true;
	}
	
	public double getCashDepozitAmmount();

}
