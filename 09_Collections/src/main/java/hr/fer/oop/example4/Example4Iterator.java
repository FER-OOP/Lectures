package hr.fer.oop.example4;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import hr.fer.oop.example3.BelowLimit;

public class Example4Iterator {

	
	
	public static void main(String[] args) throws IOException {

		List<Double> numbers = new ArrayList<>();

		// Select here source for numbers:
		//NumberSource source = new KeyboardNumberSource();
		NumberSource source = new FileNumberSource(Paths.get("numbers.txt"));
		
		double sum = 0;
		int count = 0;
		while(source.hasMoreNumbers()) {
			double number = source.getNumber();
			numbers.add(number);
			++count;
			sum += number;
		}
		
		if(!numbers.isEmpty()) {	
			double avg = sum / count;
			double limit = avg * 1.2;
						
			//sort collection
			Collections.sort(numbers);
			
			//iterate and remove those below limit
			System.out.format("Writing numbers 20%% larger than average (%.2f)%n", avg);
			
			Iterator<Double> it = numbers.iterator();
			int index=0;
			while(it.hasNext()) {
				double number = it.next();
				if (number < limit) {
					//numbers.remove(index); //Exception!
					it.remove();
				}
				else {
					System.out.println(number);
				}
				index++;
			}			
		}
	}
}
