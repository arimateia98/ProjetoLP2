package comparators;

import java.util.Comparator;

import itens.Item;

/**
 * @author Jose Vinicius
 *
 */
public class ValorComparator implements Comparator<Item> {
	
	public ValorComparator() {
	
	}

	@Override
	public int compare(Item o1, Item o2) {
		if (o1.getValor() > o2.getValor()){
			return 1;
		}
		else if (o1.getValor() == o2.getValor()){
			return 0;
		}
		else{
			return -1;
		}

	}

}
