package hr.fer.oop.streams;

import java.util.List;

public class FlatMapExample {

	public static void main(String[] args) {
		List<Student> hrStudents = StudentData.load();
		List<Student> cnStudents = StudentData.loadCN();
		List<List<Student>> studentsGroups = List.of(hrStudents, cnStudents);
		
		System.out.println("# of students in each group");
		//print number of students in each group - using method references
		studentsGroups
			.stream()
			.map(List::size) 
			.forEach(System.out::println);
		System.out.println("----");
		
		//print average number of points in each group
		System.out.println("Average points per group");
		studentsGroups
			.stream()
			.map(list -> list.stream().mapToInt(Student::getPoints).average()) 
			.forEach(System.out::println); //prints, e.g. OptionalDouble[40.0]
		System.out.println("----");
		
		//print average points of all students 
		studentsGroups
			.stream()
			.flatMap(list -> list.stream()) // or .flatMap(List::stream)
			.mapToInt(Student::getPoints)
			.average()
			.ifPresent(avg -> System.out.printf("Average points %.2f%n", avg));
			
		System.out.println("----");
		
		//print average points of all students 
		studentsGroups
			.stream()
			.flatMapToInt(list -> list.stream().mapToInt(s -> s.getPoints()))
			.average()					
			.ifPresent(avg -> System.out.printf("Average points %.2f%n", avg));
					
	    System.out.println("----");
			   	  
	    //print each student sorted by points in descending order
		studentsGroups
			.stream()
			.flatMap(list -> list.stream())
			.sorted(Student.BY_POINTS.reversed().thenComparing(Student.BY_LAST_NAME))
			.forEach(System.out::println);				
	}
	
}
