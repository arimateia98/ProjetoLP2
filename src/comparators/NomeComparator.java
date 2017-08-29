package comparators;

import java.util.Comparator;

import itens.Item;

/**
 * @author Jose Vinicius Lacerda de Arruda
 *
 */
public class NomeComparator implements Comparator<Item>  {
	@Override
	public int compare(Item o1, Item o2) {
		return o1.getNome().compareTo(o2.getNome());

	
	}

}
