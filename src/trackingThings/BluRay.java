package trackingThings;

public class BluRay extends Item{
	
	protected int duracao;
	protected String classificacao;
	
	/** 
	 * Blurays tem um nome e um valor alem de sua duracao e sua classificacao etaria
	 * @param nome
	 * @param valor
	 * @param duracao
	 * @param classificacao
	 */
	public BluRay(String nome, int valor, int duracao, String classificacao) {
		super(nome, valor);
		this.duracao = duracao;
		this.classificacao = classificacao;
	}

	/**
	 * @return duracao do Bluray
	 */
	public int getDuracao() {
		return duracao;
	}

	/**
	 * @return classificacao do Bluray
	 */
	public String getClassificacao() {
		return classificacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BluRay other = (BluRay) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
}
