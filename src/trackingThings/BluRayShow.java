package trackingThings;

public class BluRayShow extends BluRay {

	private String nomeArtista;
	private int numeroDeFaixas;

	/**
	 * Blurays de Shows possuem nome e valor alem de sua duracao, classificao, nome do artista e a quantidade de faixas presentes
	 * @param nome
	 * @param valor
	 * @param duracao
	 * @param classificacao
	 * @param nomeArtista
	 * @param numeroDeFaixas
	 */
	public BluRayShow(String nome, int valor, int duracao,  int numeroDeFaixas, String nomeArtista, String classificacao) {

		super(nome, valor, duracao, classificacao);
		this.nomeArtista = nomeArtista;
		this.numeroDeFaixas = numeroDeFaixas;
	}

	/**
	 * @return nome do artista
	 */
	public String getNomeArtista() {
		return nomeArtista;
	}

	/**
	 * @return numero de faixas do Bluray
	 */
	public int getNumeroDeFaixas() {
		return numeroDeFaixas;
	}
	
	@Override
	public String toString() {
		return "Titulo: " + this.nome + " Artista: " +  this.nomeArtista + " Nº de faixas: " + this.numeroDeFaixas;
	}
}
