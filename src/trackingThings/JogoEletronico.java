package trackingThings;

/**
 * @author Jose Ramon
 *
 */
public class JogoEletronico extends Item{
	
	private String plataforma;
	
	/**
	 * Jogos eletronicos tera um nome, um valor e uma plataforma(Pc, Xbox, Nintendo, Ps4)
	 * @param nome
	 * @param valor
	 * @param plataforma
	 */
	public JogoEletronico(String nome, double valor, String plataforma) {
		super(nome, valor);
		this.plataforma = plataforma;
	}

	/**
	 * @return plataforma do jogo
 	 */
	public String getPlataforma() {
		return plataforma;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((plataforma == null) ? 0 : plataforma.hashCode());
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
		JogoEletronico other = (JogoEletronico) obj;
		if (plataforma == null) {
			if (other.plataforma != null)
				return false;
		} else if (!plataforma.equals(other.plataforma))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "JOGO ELETRONICO: "+this.nome+", R$ "+this.valor+", "+getEmprestado()+", "+this.plataforma;
	}
	
}
