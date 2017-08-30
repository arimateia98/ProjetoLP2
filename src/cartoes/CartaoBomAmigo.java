package cartoes;

import java.io.Serializable;

public class CartaoBomAmigo implements Cartao, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public int diasPermitidos() {
		return 14;
	}
	
	@Override
	public String toString() {
		return "BomAmigo";
	}

}
