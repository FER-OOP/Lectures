package hr.fer.oop.classes.example2;

public class Student {
	final int ARR_SIZE = 60;
	private String id;
	private String name;
	private String surname;	
	private int noOfGrades;
	private CourseGrade[] grades; /* primijetiti razliku u deklaraciji polja u 	odnosu na C. 
							Ovo je slično tome da je grades pokazivač na dinamički 	
							alocirano polje */
	
	public void init(){ /* nakon 3. predavanja ovakve vlasite inicijalizacijske 
				metode ćemo zamijeniti konstruktorima */
		grades = new CourseGrade[ARR_SIZE];
		noOfGrades = 0;
	}
	
	public void addGrade(int code, String title, int grade){ //metoda klase Student
		if (grade >= 2 && grade <=5){
			CourseGrade courseGrade = new CourseGrade();
			courseGrade.code = code;
			courseGrade.title = title;
			courseGrade.grade = grade;
			grades[noOfGrades++] = courseGrade;
		}
	}
	
	public double averageGrade(){
		int sum = 0;
		for(int i=0; i<noOfGrades; i++)
			sum += grades[i].grade;
		return noOfGrades > 0 ? (double) sum / noOfGrades : 0;
	}

	public String getId() {
		return id;
	}

	public void setId(String newId) {
		id = newId;
	}

	public String getName() {
		return name;
	}

	public void setName(String newName) {
		name = newName;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String newSurname) {
		surname = newSurname;
	}
}
