package hr.fer.oop.lab6.task1;

import java.util.LinkedHashSet;
import java.util.Set;

public class Tvrtka extends PoslovniPartner {
	private String naziv;
	private Set<Osoba> zaposlenici = new LinkedHashSet<>();

	public Tvrtka(String oib, String naziv) {
		super(oib);
		this.naziv = naziv;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public Set<Osoba> getZaposlenici() {
		return zaposlenici;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("%s %s%n", naziv, getOib()));
		for (Osoba o : zaposlenici) {
			sb.append(String.format("\t %s%n", o));
		}
		return sb.toString();
	}
}
