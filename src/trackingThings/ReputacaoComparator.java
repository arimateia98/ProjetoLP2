package trackingThings;

import java.util.Comparator;

public class ReputacaoComparator implements Comparator<Usuario> {

	@Override
	public int compare(Usuario o1, Usuario o2) {
		if(o1.getReputacao() > o2.getReputacao()) {
			return -1;
		} else if(o1.getReputacao() < o2.getReputacao()) {
			return 1;
		} else {
			return 0;
		}
	}

}
