package hr.fer.oop.generics.task1;

public class Main {

	public static void main(String[] args) {
		MyList<String> list = new MyList<String>();
		   
        list.addLast("first");
        list.addLast("second");
        list.addLast("third");
        //list.addLast(35); //compile error
        
        System.out.println(list.size());
        list.removeAt(1);
        System.out.println(list.elementAt(1));
        System.out.println(list.size());
        
        list.addLast("fourth");        
        System.out.println(list.elementAt(2));  

	}

}
