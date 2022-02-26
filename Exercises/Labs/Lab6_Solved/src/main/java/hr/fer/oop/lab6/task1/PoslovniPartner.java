package hr.fer.oop.lab6.task1;

public abstract class PoslovniPartner implements Comparable<PoslovniPartner> {
	protected PoslovniPartner(String oib) {
		this.oib = oib;
	}
	private String oib;

	public final String getOib() {
		return oib;
	}
	
	@Override
	public int hashCode() {		
		return oib.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof PoslovniPartner)
			return ((PoslovniPartner) obj).oib.equals(oib);
		else
			return false;
	}	
	
	@Override
	public int compareTo(PoslovniPartner o) {
		return oib.compareTo(o.oib);
	}
}
