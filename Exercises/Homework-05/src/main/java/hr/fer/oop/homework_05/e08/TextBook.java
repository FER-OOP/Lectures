package hr.fer.oop.homework_05.e08;

public class TextBook extends Book {
	private String subject;

	public TextBook(int id, String name, String author, String subject) {
		super(id, name, author);
		this.subject = subject;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	@Override
	public String toString() {
		return super.toString() + ", subject=" + subject;
	}

}
