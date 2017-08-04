package trackingThings;

public abstract class Item {
	
	protected String nome;
	protected double valor;

	/**
	 * Cada item tem um nome e um valor
	 * @param nome
	 * @param valor
	 */
	public Item(String nome, double valor) {
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
	public double getValor() {
		return this.valor;
	}
	
	
}
