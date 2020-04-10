package hr.fer.oop.collections;
import java.util.LinkedList;
import java.util.List;

public class ListIterate {

	public static void main(String[] args) {
		List<Integer> list = new LinkedList<>();		
		for(int i=0; i<10; i++) {
			list.add(2*i);
		}
		
		for(Integer i : list)
			System.out.println(i);		
	}
}
