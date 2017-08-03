package trackingThings;

import java.util.ArrayList;

/**
 * Cada Usuario tera um nome, telefone, email e um conjunto de itens
 *	
 */
public class Usuario {
	
	private String nome;
	private String telefone;
 	private String email;
 	private ArrayList <Item> itensPossuidos;
	private ArrayList <Item> itensEmprestados;
	
	public Usuario(String nome,String telefone, String email) {
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.itensEmprestados = new ArrayList<>();
		this.itensPossuidos = new ArrayList<>();
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
	public ArrayList<Item> getItensPossuidos() {
		return itensPossuidos;
	}

	/**
	 * Isso eh necessario?
	 * @param itensPossuidos
	 */
	public void setItensPossuidos(ArrayList<Item> itensPossuidos) {
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
	
	
	
	
	
}
