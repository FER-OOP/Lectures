package hr.fer.oop.homework_09.t08;

import java.util.Map;
import java.util.TreeMap;

public class Polynom {
	private TreeMap<Integer, Integer> map = new TreeMap<>();
	private Polynom() {
		
	}
	public Polynom(int...elements) {
		for(int i=0; i<elements.length; i+=2) {			
			map.put(elements[i+1], elements[i]);
		}
	}
	
	public Polynom plus(Polynom p) {
		Polynom r = new Polynom();
		
		var it1 = this.map.entrySet().iterator();		
		var it2 = p.map.entrySet().iterator();
		Map.Entry<Integer, Integer> p1 = it1.hasNext() ? it1.next() : null;
		Map.Entry<Integer, Integer> p2 = it2.hasNext() ? it2.next() : null;
		while(p1 != null && p2 != null) {						
			
			if (p1.getKey() < p2.getKey()) {
				r.map.put(p1.getKey(), p1.getValue());
				p1 = it1.hasNext() ? it1.next() : null;				
			}
			else if (p1.getKey() > p2.getKey() ) {
				r.map.put(p2.getKey(), p2.getValue());
				p2 = it2.hasNext() ? it2.next() : null;
			}
			else {
				int val = p1.getValue() + p2.getValue();
				if (val != 0) {
					r.map.put(p2.getKey(), val);					
				}
				p1 = it1.hasNext() ? it1.next() : null;
				p2 = it2.hasNext() ? it2.next() : null;
			}			
		}
		
		while(p1 != null) {
			r.map.put(p1.getKey(), p1.getValue());
			p1 = it1.hasNext() ? it1.next() : null;
		}
		while(p2 != null) {			
			r.map.put(p2.getKey(), p2.getValue());
			p2 = it2.hasNext() ? it2.next() : null;
		}
		
		return r;
	}
	
	@Override
	public String toString() {
		String s = "";
		boolean previousWasPositive = true;
		for(Map.Entry<Integer, Integer> entry : map.entrySet()) {	//ordered by power (ascending)		
			String current = "";
			if (entry.getKey() == 0) {
				current = entry.getValue().toString();				
			}
			else if (entry.getKey() == 1) {
				int val = entry.getValue();				
				current = val != 1 ? val + "x" : "x";				
			}
			else {
				int val = entry.getValue();
				if (val != 1) {
					current = entry.getValue() + "x^" + entry.getKey();
				}
				else {
					current = "x^" + entry.getKey();
				}
			}
			
			if (s.length() == 0) {
				s = current;
			}
			else {
				if (previousWasPositive) {
					s = current + "+" + s;
				}
				else {
					s = current + s;
				}
			}
				
			previousWasPositive = entry.getValue() > 0;
				
		}
		return s;
	}
}
