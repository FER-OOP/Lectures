package hr.fer.oop.homework_11.e8;

import java.util.List;
import hr.fer.oop.homework_11.person.*;

public class Main {

	public static void main(String[] args) {
			
		List<Integer> result = new Sequence<>("OOP", "is", "your", "world", ".")
                .filter(s-> true)
                .map(s-> s.length()) 
                .toList();
		System.out.println(result);
	
		new Sequence<>("OOP", "is", "your", "world", ".")
		.filter((s)->s.length()<4)
		.map((s)-> { if(s.length()%2==0)
						return s + " string has an even number of characters";
					 	return s + " string has an odd number of characters";			
				   })
		.forEach((i)->System.out.println(i));
			
		boolean areAllVragec = new Sequence<>(Person.loadPersons())
								.all((p)-> p.getSurname().equals("Vragec"));
		System.out.println(areAllVragec);
		
	}

}
