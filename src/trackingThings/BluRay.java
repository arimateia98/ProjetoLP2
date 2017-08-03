package trackingThings;

public class BluRay extends Item{
	
	private int duracao;
	private String classificacao;
	
	public BluRay(String nome, int valor, int duracao, String classificacao) {
		super(nome, valor);
		this.duracao = duracao;
		this.classificacao = classificacao;

	}

	public int getDuracao() {
		return duracao;
	}

	public String getClassificacao() {
		return classificacao;
	}
}
