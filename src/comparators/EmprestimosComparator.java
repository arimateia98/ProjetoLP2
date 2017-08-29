package comparators;

import java.util.Comparator;

import itens.Item;

public class EmprestimosComparator implements Comparator <Item> {

	@Override
	public int compare(Item o1, Item o2) {
		if (o1.getEmprestimosOcorridos().size() > o2.getEmprestimosOcorridos().size()){
			return -1;
		} else if (o1.getEmprestimosOcorridos().size() < o2.getEmprestimosOcorridos().size()) {
			return 1;
		} else {
			return 0;
		}
	}

}
