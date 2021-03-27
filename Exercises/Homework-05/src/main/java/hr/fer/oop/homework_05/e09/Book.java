package hr.fer.oop.homework_05.e09;

public class Book extends LibraryItem {
	private String author;

	public Book(int id, String name, String author) {
		super(id, name);
		this.author = author;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return super.toString() + ", author=" + author;
	}

	@Override
	public int getLoanPeriod() {
		return 14;
	}
	
}