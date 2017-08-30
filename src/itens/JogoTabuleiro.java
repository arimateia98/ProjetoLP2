package itens;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import estadosenum.EstadoTabuleiro;

/**
 * @author Jose Ramon
 *
 */
public class JogoTabuleiro extends Item implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private EstadoTabuleiro estadoTabuleiro;
	private List<String> pecasTotais;
	private List<String> pecasPerdidas;

	/**
	 * Jogos de tabuleiro tera alem do nome e do valor, um array de pecas perdidas e um array de pecas totais
	 * @param nome
	 * @param valor
	 */
	public JogoTabuleiro(String nome, double valor) {
		super(nome, valor);
		this.estadoTabuleiro = EstadoTabuleiro.COMPLETO;
		this.pecasPerdidas = new ArrayList<>();
		this.pecasTotais = new ArrayList<>();
	}

	/**
	 * @return lista de pecas perdidas
	 */
	public List<String> getPecasPerdidas() {
		return pecasPerdidas;
	}

	public List<String> getPecasTotais() {
		return pecasTotais;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((pecasPerdidas == null) ? 0 : pecasPerdidas.hashCode());
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
		JogoTabuleiro other = (JogoTabuleiro) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (pecasPerdidas == null) {
			if (other.pecasPerdidas != null)
				return false;
		} else if (!pecasPerdidas.equals(other.pecasPerdidas))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "JOGO DE TABULEIRO: " + this.nome + ", R$ "+this.valor +", "+ this.getEmprestado() + ", "+this.seHaPecasPerdidas();

	}
	
	/**
	 * Diz que uma peca foi perdida
	 * @param nomePeca
	 */
	public void adicionarPecaPerdida(String nomePeca) {
		this.pecasPerdidas.add(nomePeca);
		this.estadoTabuleiro = EstadoTabuleiro.INCOMPLETO;
	}
	
	/**
	 * Diz  se tem uma peca perdida
	 * @return
	 */
	public String seHaPecasPerdidas(){
		return this.estadoTabuleiro.getMensagem();
	}
}
