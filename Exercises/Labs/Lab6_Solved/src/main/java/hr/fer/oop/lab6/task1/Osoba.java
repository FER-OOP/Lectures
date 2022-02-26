package hr.fer.oop.lab6.task1;

public class Osoba extends PoslovniPartner {
	private String ime;
	private String prezime;

	public Osoba(String oib, String ime, String prezime) {		
		super(oib);
		this.setIme(ime);
		this.setPrezime(prezime);
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	
	@Override
	public String toString() {
		return String.format("%s %s - %s", ime, prezime, getOib());
	}
}
