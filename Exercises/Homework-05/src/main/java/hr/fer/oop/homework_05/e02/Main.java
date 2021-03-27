package hr.fer.oop.homework_05.e02;

public class Main {

	public static void main(String[] args) {
		
		//Computer c = new Computer("HP Pavilion", "HP", "FreeDOS"); // Computer je sad abstract
		Computer c = new Desktop("HP Pavilion", "HP", "FreeDOS", 52);
		Desktop d = new Desktop("Alienware R10", "Dell", "Linux", 45);
		Laptop l = new Laptop("Legion 7", "Lenovo", "Windows", 80, 2.25);

		System.out.println(c);
		System.out.println(d);
		System.out.println(l);
	}

}
