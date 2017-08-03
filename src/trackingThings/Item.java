package trackingThings;

public abstract class Item {
	
	protected String nome;
	protected int valor;

	/**
	 * Cada item tem um nome e um valor
	 * @param nome
	 * @param valor
	 */
	public Item(String nome, int valor) {
		this.nome = nome;
		this.valor = valor;
	}

	/**
	 * @return nome do item
	 */
	public String getNome() {
		return this.nome;
	}
		
	/**
	 * @return valor do item
	 */
	public int getValor() {
		return this.valor;
	}
	
	
}
