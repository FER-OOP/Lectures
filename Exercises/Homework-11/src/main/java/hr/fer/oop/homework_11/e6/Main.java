package hr.fer.oop.homework_11.e6;


import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import hr.fer.oop.homework_11.person.Person;

public class Main {

	public static void main(String[] args) {
		
		List<Person> persons = Person.loadPersons();
		persons.forEach((p)->System.out.println(p));
		System.out.println();
		
		Comparator<Person> comparator = (p1, p2) -> p1.getName().compareTo(p2.getName());
        persons.sort(comparator.reversed());
        persons.forEach(System.out::println);
        System.out.println();
        		
		persons.removeIf(p->p.getName().charAt(0)=='S');
        persons.forEach(System.out::println); 
        System.out.println();
		   
        Map<Integer, String> personMap = convertIterablePersonsToMap(persons);
		System.out.println(personMap);
		System.out.println();
		
		Map<Integer, Integer> map1 = convertIterableToMap(persons,  (p)->p.getId() /*Person::getId*/ , 
																	(p)->p.getAge() /*Person::getAge*/);
		map1.forEach((k, v)-> System.out.println("{" + k + "=" + v + "}") );

	}
	
	public static Map<Integer, String> convertIterablePersonsToMap(Iterable<? extends Person> persons){
		Map<Integer, String> map = new HashMap<>();
	    for (Person p : persons) {
	        map.put(p.getId(), p.getName() + " " + p.getSurname()); // hard coded mapping rule
	    }
		return map;
	}
	
	public static <K, V, E> Map<K, V> convertIterableToMap(Iterable<? extends E> elements,
                                             Function<E, K> keyFunction,
                                             Function<E, V> valueFunction) {
    	Map<K, V> map = new HashMap<>();
    	Iterator<? extends E> iter = elements.iterator();
        while (iter.hasNext()) {
            E temp = iter.next();
            map.put(keyFunction.apply(temp), valueFunction.apply(temp));
        }
        return map;
    }

}

