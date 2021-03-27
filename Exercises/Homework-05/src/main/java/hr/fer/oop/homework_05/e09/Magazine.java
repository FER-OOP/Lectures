package hr.fer.oop.homework_05.e09;

public class Magazine extends LibraryItem {
	private String contentCategory;
	private int issue;
	
	public Magazine(int id, String name, String contentCategory, int issue) {
		super(id, name);
		this.contentCategory = contentCategory;
		this.issue = issue;
	}

	public String getContentCategory() {
		return contentCategory;
	}

	public void setContentCategory(String contentCategory) {
		this.contentCategory = contentCategory;
	}

	public int getIssue() {
		return issue;
	}

	public void setIssue(int issue) {
		this.issue = issue;
	}

	@Override
	public String toString() {
		return super.toString() + ", contentCategory=" + contentCategory + ", issue=" + issue;
	}

	@Override
	public int getLoanPeriod() {
		return 7;
	}
}