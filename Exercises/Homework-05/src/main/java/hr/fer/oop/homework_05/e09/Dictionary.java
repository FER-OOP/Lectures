package hr.fer.oop.homework_05.e09;

public class Dictionary extends Book {
	private String firstLanguage;
	private String secondLanguage;
	
	public Dictionary(int id, String name, String author, String firstLanguage, String secondLanguage) {
		super(id, name, author);
		this.firstLanguage = firstLanguage;
		this.secondLanguage = secondLanguage;
	}

	public String getFirstLanguage() {
		return firstLanguage;
	}

	public void setFirstLanguage(String firstLanguage) {
		this.firstLanguage = firstLanguage;
	}

	public String getSecondLanguage() {
		return secondLanguage;
	}

	public void setSecondLanguage(String secondLanguage) {
		this.secondLanguage = secondLanguage;
	}

	@Override
	public String toString() {
		return super.toString() + ", firstLanguage=" + firstLanguage + ", secondLanguage=" + secondLanguage;
	}

}