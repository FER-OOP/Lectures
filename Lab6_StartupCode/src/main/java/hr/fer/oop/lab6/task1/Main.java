package hr.fer.oop.lab6.task1;

import java.util.Collection;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) {
		Collection<PoslovniPartner> col = new TreeSet<>(new PoslovniPartnerComparator()) ;
		Osoba o1 = new Osoba("42345678901", "Darko", "Plavac");
		Osoba o2 = new Osoba("58855678121", "Bianka", "Malvazija");
		Osoba o3 = new Osoba("28964789143", "Vigor", "Votkiæ");
		Osoba o4 = new Osoba("15678842125", "Pelinko", "Badel");
		Osoba o5 = new Osoba("35678842125", "Kruško", "Rakijiæ");
		
		Tvrtka t1 = new Tvrtka("66879845127", "Meho und jaranen");		
		Tvrtka t2 = new Tvrtka("45174579172", "Otraj-dotraj");
		Tvrtka t3 = new Tvrtka("25174579172", "Kupi-prodaj");
		
		t1.getZaposlenici().add(o1);
		t1.getZaposlenici().add(new Osoba("42345678901", "Darko", "Plavac"));
		t1.getZaposlenici().add(o1);
		t1.getZaposlenici().add(o4);
		
		t2.getZaposlenici().add(o3);
		t2.getZaposlenici().add(o2);
		t2.getZaposlenici().add(o1);
		
		t3.getZaposlenici().add(o2);
		t3.getZaposlenici().add(o3);
		t3.getZaposlenici().add(o4);
		
		col.add(t1);
		col.add(o5);
		col.add(t2);
		col.add(t3);
		
		col.forEach(System.out::println);		
	}

}
