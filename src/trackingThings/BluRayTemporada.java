package trackingThings;

import java.util.HashSet;
import java.util.Set;

public class BluRayTemporada extends BluRay {
	
	private Set<Integer> episodios; 
	private int numeroTemporada;
	private int duracaoTotal;
	
	/**
	 * Bluray de Series eh dividido em temporadas, no qual cada temporada possui uma quantidade de episodios com uma certa duracao
	 * Cada temporada tem o seu nome e o valor alem de sua duracao, classificacao e o numero da temporada
	 * @param nome
	 * @param valor
	 * @param duracao
	 * @param classificacao
	 * @param numeroTemporada
	 */
	public BluRayTemporada(String nome, int valor, int duracao, String classificacao,int numeroTemporada) {
		super(nome, valor, duracao, classificacao);
		this.episodios = new HashSet<Integer>();
		this.numeroTemporada = numeroTemporada;
		this.duracaoTotal = this.getDuracaoTotal();
	}

	/**
	 * @return episodios da Temporada
	 */
	public Set<Integer> getBlurays() {
		return this.episodios;
	}
	
	/**
	 * @return duracao total de episodios
	 */
	public int getDuracaoTotal() {

		for (Integer episodio : this.episodios) {
			this.duracaoTotal += episodio;
		}
		return this.duracaoTotal;
	}
	
	/**
	 * @return numero da temporada
	 */
	public int getNumeroTemporada() {
		return this.numeroTemporada;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + numeroTemporada;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		BluRayTemporada other = (BluRayTemporada) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (numeroTemporada != other.numeroTemporada)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Serie: " + this.nome + " Nº temporada: " + this.numeroTemporada + 
				" Duracao total: " + this.duracaoTotal + " Classificacao: " + this.classificacao;
	}
}
