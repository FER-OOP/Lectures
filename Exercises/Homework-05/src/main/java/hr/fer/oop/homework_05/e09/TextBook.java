package hr.fer.oop.homework_05.e09;

public class TextBook extends Book implements ItemWithCashDepozit {
	private String subject;
	private double cashDepozitAmmount;

	public TextBook(int id, String name, String author, String subject, double cashDepozitAmmount) {
		super(id, name, author);
		this.subject = subject;
		this.cashDepozitAmmount = cashDepozitAmmount;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public double getCashDepozitAmmount() {
		return cashDepozitAmmount;
	}

	public void setCashDepozitAmmount(double cashDepozitAmmount) {
		this.cashDepozitAmmount = cashDepozitAmmount;
	}

	@Override
	public String toString() {
		return super.toString() + ", subject=" + subject;
	}

	public boolean hasCashDeposit() {
		if (cashDepozitAmmount == 0)
			return false;
		return true;
	}
}