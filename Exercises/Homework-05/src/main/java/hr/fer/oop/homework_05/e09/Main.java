package hr.fer.oop.homework_05.e09;

import java.net.MalformedURLException;
import java.net.URL;

public class Main {

	public static void main(String[] args) throws MalformedURLException { //throws æemo nauèiti uskoro

		Book book = new Book(1351, "The Hitchhiker's Guide to the Galaxy", "Douglas Adams");
		Dictionary dict = new Dictionary(1652, "Englezko-hrvatski rjeènik obavjestnièkoga nazivlja", "Zdenko Škiljan", "Hrvatski", "Engleski");
		Magazine magazine = new Magazine(1871, "Hacker", "computer games", 321);
		DigitalItem di = new DigitalItem(2162, "Microsoft Encarta", "DVD", 50);		
		TextBook tb = new TextBook(3176, "Demistificirani C++", "Šribar & Motik", "ASP", 0);
		EItem ei = new EItem(3217, "Programiranje u Javi", new URL("http://java.zemris.fer.hr/nastava/opjj/book-2015-09-30.pdf"));

		LibraryItem[] items = new LibraryItem[] {book, dict, magazine, di, tb, ei};

		for (LibraryItem item : items) {
			System.out.println(item.getId() + " " + item.getName());
			if (item instanceof ItemWithCashDepozit && ((ItemWithCashDepozit)item).hasCashDeposit())
				System.out.println(" +- cash depozit: " + ((ItemWithCashDepozit)item).getCashDepozitAmmount());
		}
	}

}
