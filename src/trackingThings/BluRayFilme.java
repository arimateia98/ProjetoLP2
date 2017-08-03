package trackingThings;

//Blu ray. Blu ray pode ser de filmes, séries ou shows.
//Além das informações gerais que todo item tem (descritas anteriormente), todo 
//blu ray deve ter uma duração e uma classificação[2]



//Os blu rays de filmes devem ainda ter gênero[3] e ano de lançamento
//. Os blu rays de shows devem indicar o nome do artista e o número de faixas. 
//Dois blu rays são iguais se tiverem o mesmo nome. Dois blu-rays de temporada são iguais se tiverem
//o mesmo nome e mesmo número de temporada.

public class BluRayFilme extends BluRay {
	
	private String genero;
	private String anoDeLancamento;
	
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
			String anoDeLancamento) {
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
	public String getAnoDeLancamento() {
		return anoDeLancamento;
	}
	
	@Override
	public String toString() {
		return "Nome: " + this.nome + " Ano: " + this.anoDeLancamento +
				" Genero : " + this.genero + " Classificacao: " + this.classificacao; 
	}
}
