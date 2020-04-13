package hr.fer.oop.generics.list;

public class Main {

	public static void main(String[] args) {
		MyList<String> list = new MyList<>();
		   
        list.add("F");
        list.add("B");
        list.add("C");
        list.add("H");
        list.add("A");
        list.add("E");
        list.add("G");
        list.print();
                
        list.removeAt(1);
        list.print();
        
        list.add("D");
        list.print();
        
        //list.add(1); //compile error   

	}

}
