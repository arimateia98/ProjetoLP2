package trackingThings;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Cada Usuario tera um nome, telefone, email e um conjunto de itens
 *	
 */
public class Usuario {
	
	private String nome;
	private String telefone;
 	private String email;
 	private HashMap <String,Item> itensPossuidos;
	private ArrayList <Item> itensEmprestados;
	
	public Usuario(String nome,String telefone, String email) {
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.itensEmprestados = new ArrayList<>();
		this.itensPossuidos = new HashMap<>();
	}

	/**
	 * @return nome do Usuario
	 */
	public String getNome() {
		return this.nome;
	}

	/**
	 * Mudanca no nome do Usuario
	 * @param nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return telefone do Usuario
	 */
	public String getTelefone() {
		return this.telefone;
	}

	/**
	 * Mudanca no telefone do Usuario
	 * @param telefone
	 */
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	/**
	 * @return email do Usuario
	 */
	public String getEmail() {
		return this.email;
	}

	/**
	 * Mudanca no email do Usuario
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return lista de itens de um Usuario
	 */
	public ArrayList<Item> getItensEmprestados() {
		return this.itensEmprestados;
	}

	/**
	 * Mudanca na lista de itens de um Usuario
	 * @param itens
	 */
	public void setItensEmprestrados(ArrayList<Item> itens) {
		this.itensEmprestados = itens;
	}

	/**
	 * @return lista de itens pegos
	 */
	public HashMap<String, Item> getItensPossuidos() {
		return itensPossuidos;
	}

	/**
	 * Isso eh necessario?
	 * @param itensPossuidos
	 */
	public void setItensPossuidos(HashMap<String, Item> itensPossuidos) {
		this.itensPossuidos = itensPossuidos;
	}

	/* 
	 * toString do Usuario
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.nome + "," + this.email + "," + this.telefone;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((telefone == null) ? 0 : telefone.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (telefone == null) {
			if (other.telefone != null)
				return false;
		} else if (!telefone.equals(other.telefone))
			return false;
		return true;
	}

	public void cadastrarEletronico(String nomeItem, Double preco, String plataforma) {
		JogoEletronico jogoEletronico = new JogoEletronico(nomeItem, preco, plataforma);
		itensPossuidos.put(nomeItem, jogoEletronico);
	}

	public void cadastrarJogoTabuleiro(String nomeItem, Double preco) {
		JogoTabuleiro jogoTabuleiro = new JogoTabuleiro(nomeItem, preco);
		itensPossuidos.put(nomeItem, jogoTabuleiro);
	}

	public void adicionarPecaPerdida(String nomeItem, String nomePeca) {
		((JogoTabuleiro) itensPossuidos.get(nomeItem)).adicionarPecaPerdida(nomePeca);
	}

	public void cadastrarBluRayFilme(String nomeItem, Double preco, int duracao, String genero,String classificacao,
			int anoLancamento) {
		BluRayFilme bluRayFilme = new BluRayFilme(nomeItem, preco, duracao, classificacao, genero, anoLancamento);
		itensPossuidos.put(nomeItem, bluRayFilme);
	}

	public void cadastrarBluRayShow(String nomeItem, Double preco, int duracao, int numeroFaixas, String artista,
			String classificacao) {
		BluRayShow bluRayShow = new BluRayShow(nomeItem, preco, duracao, numeroFaixas, artista, classificacao);
		itensPossuidos.put(nomeItem, bluRayShow);
	}

	public void cadastrarBluRaySerie(String nomeItem, Double preco, String descricao, int duracao, String classificacao,
			String genero, int temporada) {
		BluRayTemporada bluRaySerie = new BluRayTemporada(nomeItem, preco, duracao, classificacao, temporada);
		itensPossuidos.put(nomeItem, bluRaySerie);
	}

	public void adicionarBluRay(String nomeBlurayTemporada, int duracao) {
		((BluRayTemporada) itensPossuidos.get(nomeBlurayTemporada)).addEpisodio(duracao);
		((BluRayTemporada) itensPossuidos.get(nomeBlurayTemporada))
		.setDuracaoTotal(((BluRayTemporada) itensPossuidos.get(nomeBlurayTemporada)).getDuracaoTotal());
	}

	public void removerItem(String nomeItem) {
		itensPossuidos.remove(nomeItem);
	}

	public void atualizarItem(String nomeItem, String atributo, String valor) {
		if (!itensPossuidos.containsKey(nomeItem)){
			throw new NullPointerException("Item invalido");
		}
		
		if (atributo.toLowerCase().equals("nome")){
			itensPossuidos.get(nomeItem).setNome(valor);
			this.itensPossuidos.put(valor,itensPossuidos.get(nomeItem));
			itensPossuidos.remove(nomeItem);
		}	
		else if (atributo.toLowerCase().equals("valor")){
			this.itensPossuidos.get(nomeItem).setValor(Double.parseDouble(valor));
		}
	}

	public String getInfoItem(String nomeItem) {
		return null;
	}
	
	
	
	
	
	
	
	
	
}
