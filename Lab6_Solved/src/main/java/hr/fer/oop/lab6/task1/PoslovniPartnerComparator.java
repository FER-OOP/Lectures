package hr.fer.oop.lab6.task1;

import java.util.Comparator;

public class PoslovniPartnerComparator implements Comparator<PoslovniPartner> {

	@Override
	public int compare(PoslovniPartner o1, PoslovniPartner o2) {
		if (o1 instanceof Tvrtka && o2 instanceof Tvrtka) {
			int result = ((Tvrtka) o2).getZaposlenici().size() - ((Tvrtka) o1).getZaposlenici().size();
			if (result == 0){
				result = o1.getOib().compareTo(o2.getOib());
			}
			return result;
		}
		else if (o1 instanceof Tvrtka){
			return -1;
		}
		else if (o2 instanceof Tvrtka) {
			return 1;
		}
		else {
			return o1.compareTo(o2);
		}
	}

}
