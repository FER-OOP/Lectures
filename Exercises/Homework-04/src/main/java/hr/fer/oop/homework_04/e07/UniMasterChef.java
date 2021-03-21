package hr.fer.oop.homework_04.e07;

import hr.fer.oop.homework_04.e01.Dessert;
import hr.fer.oop.homework_04.e02.Cake;
import hr.fer.oop.homework_04.e03.Person;
import hr.fer.oop.homework_04.e04.Student;
import hr.fer.oop.homework_04.e04.Teacher;
import hr.fer.oop.homework_04.e06.CompetitionEntry;

public class UniMasterChef {
	
	private CompetitionEntry[] entries;
	
	//internal, for addEntry
	private int idx = 0;
	
	public UniMasterChef(int noOfEntries) {
		this.entries = new CompetitionEntry[noOfEntries];
	}

	public boolean addEntry (CompetitionEntry entry) {
		if (idx == this.entries.length) return false; //full
		
		for (CompetitionEntry e : entries) {
			if (e != null && e.equals(entry))
				return false; //already in
		}
		
		entries[idx++] = entry;
		return true;
	}	
	
	public Dessert getBestDessert() {
		if (idx==0) return null;

		double max = entries[0].getRating();
		int maxIdx = 0; 		
		
		for (int i=0; i<idx; i++) {
			if (entries[i].getRating()>max) {
				max = entries[i].getRating();
				maxIdx = i;
			}
		}
		
		return entries[maxIdx].getDessert();
	}

	public static Person[] getInvolvedPeople(CompetitionEntry entry) {
		
		Person[] retVal = new Person[4]; //max, can we calculate the size? 
		//Should entry.idx be public? or should this method be non-static?
		//What if we want a method that accepts variable number of entries? (CompetitionEntry...entries) ?
		//Later on in the course we will learn about List and Set, which will make our life much easier :)
		
		int idx = 0;
		
		retVal[idx++] = entry.getTeacher();
		
		for (Student s : entry.getStudents()) {
			retVal[idx++] = s;	// what about nulls?
		}
		
		return retVal;
	}
	
	public static void main(String[] args) {
		
		Dessert genericDessert = new Dessert("Chocolate Mousse", 120, 300);		
		Cake cake = new Cake("Raspberry chocolate cake #3", 350.5, 400, false, "birthday");
		
		Teacher t1 = new Teacher("Dario", "Tušek", 42, "dario.tusek@fer.hr", "OOP", 10000);
		Teacher t2 = new Teacher("Doris", "Bezmalinović", 43, "doris.bezmalinovic@fer.hr", "OOP", 10000);
		
		Student s1 = new Student("Janko", "Horvat", 18, "0036312123", (short)1);
		Student s2  = new Student("Ana", "Kovač", 19, "0036387656", (short)2);
		Student s3  = new Student("Ivana", "Stanić", 19, "0036392357", (short)1);
		
		UniMasterChef competition = new UniMasterChef(2);
		
		CompetitionEntry e1 = new CompetitionEntry(t1, genericDessert);		
		competition.addEntry(e1);
		System.out.println("Entry 1 rating: " + e1.getRating());
		
		e1.addRating(s1, 4);
		e1.addRating(s2, 5);
		System.out.println("Entry 1 rating: " + e1.getRating());
		
		CompetitionEntry e2 = new CompetitionEntry(t2, cake);
		e2.addRating(s1, 4);
		e2.addRating(s3, 5);
		e2.addRating(s2, 5);
		competition.addEntry(e2);		
		System.out.println("Entry 2 rating: " + e2.getRating());
		
		System.out.println("Best dessert is: " + competition.getBestDessert().getName());
		
		Person[] e2persons = UniMasterChef.getInvolvedPeople(e2);
		
		for (Person p : e2persons)
			System.out.println(p);

	}
}
