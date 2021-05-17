package hr.fer.oop.homework_11.e8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Sequence <T> {
	private List<T> values;
	
	@SafeVarargs
	public Sequence(T... values) {
        this.values = Arrays.asList(values);
    }

    public Sequence(List<T> values) {
        this.values = values;
    }
   
    public Sequence<T> filter(Predicate<T> filter) {
        List<T> returnedList = new ArrayList<>();
        for (T value : values) {
            if (filter.test(value)) {
            	returnedList.add(value);
            }
        }
        return new Sequence<T>(returnedList);
    }
	
    public <R> Sequence<R> map(Function<? super T,? extends R> mapper){
        List<R> returnedList = new ArrayList<>();
        for (T value : values) {
        	returnedList.add(mapper.apply(value));
        }
        return new Sequence<R>(returnedList); 
    }
    
    public void forEach(Consumer<T> action) {
        for (T value : values) {
            action.accept(value);
        }
    }
    
    public List<T> toList() {
        return this.values;
    }
    
    public Boolean all(Predicate<T> predicate) {
  		 for(T t: values)
  			 if(!predicate.test(t)) return false;
  		 return true;
  	 }
   
}
