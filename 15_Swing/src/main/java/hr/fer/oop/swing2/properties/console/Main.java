package hr.fer.oop.swing2.properties.console;

import java.beans.PropertyChangeListener;

public class Main {

	public static void main(String[] args) {
		A a = new A();
		PropertyChangeListener listener = evt -> {
			System.out.printf("\tProperty %s changed from %d to %d%n", 
					evt.getPropertyName(), 
					evt.getOldValue(), 
					evt.getNewValue());
		};
		a.addPropertyChangeListener(listener);
		
		System.out.println("Command #1 -> val to 25");
		a.setValue(25);
		System.out.println("Command #2 -> val to 35");
		a.setValue(35);
		System.out.println("Command #3 -> val to 35");
		a.setValue(35);
		System.out.println("Command #4 -> val to 45");
		a.setValue(45);
		
		a.removePropertyChangeListener(listener);
		
		System.out.println("Command #5 -> val to 75");
		a.setValue(75);

	}

}
