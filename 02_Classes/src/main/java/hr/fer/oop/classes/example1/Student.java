package hr.fer.oop.classes.example1;

class Student {
	final int ARR_SIZE = 60;
	String id;
	String name;
	String surname;	
	int noOfGrades;
	CourseGrade[] grades; /* primijetiti razliku u deklaraciji polja u 	odnosu na C. 
							Ovo je slično tome da je grades pokazivač na dinamički 	
							alocirano polje pokazivača*/
	
	void init(){ /* nakon 3. predavanja ovakve vlastite inicijalizacijske 
				metode ćemo zamijeniti konstruktorima */
		grades = new CourseGrade[ARR_SIZE];
		noOfGrades = 0;
	}
	
	void addGrade(int code, String title, int grade){ //metoda klase Student
		if (grade >= 2 && grade <=5){
			CourseGrade courseGrade = new CourseGrade();
			courseGrade.code = code;
			courseGrade.title = title;
			courseGrade.grade = grade;
			grades[noOfGrades++] = courseGrade;
		}
	}
	
	double averageGrade(){
		int sum = 0;
		for(int i=0; i<noOfGrades; i++)
			sum += grades[i].grade;
		return noOfGrades > 0 ? (double) sum / noOfGrades : 0;
	}
}
