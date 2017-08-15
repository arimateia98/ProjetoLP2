package trackingThings;

import java.util.Comparator;

public class EmprestimosComparator implements Comparator <Item> {

	@Override
	public int compare(Item o1, Item o2) {
		if (o1.getQntdEmprestimos > o2.getQntdEmprestimos) {
			return 1;
		} else if (o1.getQntdEmprestimos < o2.getQntdEmprestimos) {
			return -1;
		} else {
			return 0;
		}
	}

}
