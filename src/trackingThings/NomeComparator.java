package trackingThings;

import java.util.Comparator;

public class NomeComparator implements Comparator<Item>  {
	
	public NomeComparator() {
	
	}
	
	@Override
	public int compare(Item o1, Item o2) {
		return o1.getNome().compareTo(o2.getNome());

	
	}

}
