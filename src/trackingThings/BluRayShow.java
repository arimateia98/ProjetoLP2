package trackingThings;

public class BluRayShow extends BluRay {

	private String nomeArtista;
	private int numeroDeFaixas;

	public BluRayShow(String nome, int valor, int duracao, String classificacao, String nomeArtista, int numeroDeFaixas) {

		super(nome, valor, duracao, classificacao);
		this.nomeArtista = nomeArtista;
		this.numeroDeFaixas = numeroDeFaixas;
	}

	public String getNomeArtista() {
		return nomeArtista;
	}

	public int getNumeroDeFaixas() {
		return numeroDeFaixas;
	}
	
	@Override
	public String toString() {
		return "Titulo: " + this.nome + " Artista: " +  this.nomeArtista + " Nº de faixas: " + this.numeroDeFaixas;
	}
}
