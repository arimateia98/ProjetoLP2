package trackingThings;

public class BluRayFilme extends BluRay {
	
	private String genero;
	private int anoDeLancamento;
	
	/**
	 * Blurays de Filmes tem o nome e o seu valor alem de sua duracao, classificacao etaria, genero e o seu ano de lancamento
	 * @param nome
	 * @param valor
	 * @param duracao
	 * @param classificacao
	 * @param genero
	 * @param anoDeLancamento
	 */
	public BluRayFilme(String nome, int valor, int duracao, String classificacao, String genero,
			int anoDeLancamento) {
		super(nome, valor, duracao, classificacao);
		this.genero = genero;
		this.anoDeLancamento = anoDeLancamento;
	}

	/**
	 * @return genero do filme
	 */
	public String getGenero() {
		return genero;
	}

	/**
	 * @return ano de lancamento do filme
	 */
	public int getAnoDeLancamento() {
		return anoDeLancamento;
	}
	
	@Override
	public String toString() {
		return "Nome: " + this.nome + " Ano: " + this.anoDeLancamento +
				" Genero : " + this.genero + " Classificacao: " + this.classificacao; 
	}
}
