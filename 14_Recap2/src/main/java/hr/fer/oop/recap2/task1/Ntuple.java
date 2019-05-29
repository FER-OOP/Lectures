package hr.fer.oop.recap2.task1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Ntuple<T extends Comparable<T>> implements Comparable<Ntuple<T>> {
	private List<T> data;
	
	public int size() {
		return data.size();
	}
	
	public T get(int index) {
		return data.get(index - 1);
	}
	public void set(int index, T element) {
		data.set(index - 1, element);
	}	
	
	@SuppressWarnings("unchecked")
	public Ntuple(T first, T second, T...others) {
		data = new ArrayList<>(others.length + 2);
		data.add(first);
		data.add(second);
		for(int i=0; i<others.length; i++)
			data.add(others[i]);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append('(');
		//variant 1:
//		boolean addcomma = false;
//		for(T t : data) {
//			if (addcomma)
//				sb.append(", ");
//			sb.append(t.toString());
//			addcomma = true;
//		}
		
		//variant 2: 
		String joined = data.stream()
						    .map(t -> t.toString())
							.collect(Collectors.joining(", "));
		sb.append(joined);
		
		sb.append(')');
		return sb.toString();
	}
	
	@Override
	public boolean equals(Object obj) {	
		// cannot write if (obj instanceof NTuple<T>) due to Java generics, but we can do 
		//if (this.getClass().isInstance(obj)) or (due to Java Erasure)
		if (obj instanceof Ntuple) {		
			Ntuple<?> other = (Ntuple<?>) obj; //Ntuple<T> or NTuple raise warning, and it is not necessary
			if (other.data.size() != this.data.size())
				return false;
			for(int i=0; i<data.size(); i++) {
				if (!this.data.get(i).equals(other.data.get(i)))
					return false;
			}
			return true;
		}
		else {
			return false;
		}							
	}
	
	@Override
	public int hashCode() {
		//not so clever, but will produce the same hashcode for equal objects
		int sum = 0;
		for(T t : data)
			sum += t.toString().hashCode(); //or t.hashCode if we can be sure that T overrides hashCode
		return sum;
	}

	@Override
	public int compareTo(Ntuple<T> o) {		
		int min = Math.min(this.size(), o.size());
		for(int i=0 ; i < min; i++) {
			int r = this.data.get(i).compareTo(o.data.get(i));
			if (r != 0)
				return r;
		}
		if (this.size() > min)
			return 1;
		if (o.size() > min)
			return -1;
		return 0;
	}	
}
