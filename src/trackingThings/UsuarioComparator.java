package trackingThings;

import java.util.Comparator;

public class UsuarioComparator implements Comparator<Usuario> {

	@Override
	public int compare(Usuario o1, Usuario o2) {
		if (o1.getNome().equals(o2.getNome()) && o1.getEmail().equals(o2.getEmail())) {
			return 1;
		}
		else {
			return -1;
		}
	}

}
