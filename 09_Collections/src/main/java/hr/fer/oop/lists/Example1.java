package hr.fer.oop.lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Example1 {

	public static void main(String[] args) {	
		//List<String> list = Arrays.asList("Ivo", "Ana", "Jasna");
		List<String> list = List.of("Ivo", "Ana", "Jasna");
		
		List<String> list1 = new ArrayList<>(list);
		write(list1);
		List<String> list2 = new LinkedList<>(list);
		write(list2);							
	}

		
//	private static void write(List<String> list) {
//		for(int i = 0, n = list.size(); i<n; i++) {
//			System.out.println(list.get(i));
//		}
//	}

//  What is the difference between this "write" and
//	the uncommented one?
//	private static void write(List<String> list) {
//		for(int i = 0; i<list.size(); i++) {
//			System.out.println(list.get(i));
//		}
//	}
	
//  What is the difference between this "write" and
//	the uncommented one?
	private static void write(List<String> list) {
		for(String s : list) {
			System.out.println(s);
		}
	}

	
	
	
	
}
