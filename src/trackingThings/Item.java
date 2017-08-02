package trackingThings;

public abstract class Item {
	
	protected String nome;
	protected int valor;

	public Item(String nome, int valor) {
		this.nome = nome;
		this.valor = valor;
	}

	public String getNome() {
		return this.nome;
	}
		
	public int getValor() {
		return this.valor;
	}

}
