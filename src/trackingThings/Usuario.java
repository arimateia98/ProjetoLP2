package trackingThings;

import java.util.ArrayList;

/**
 * Cada Usuario terá um nome, telefone, email e um conjunto de itens
 *	
 */
public class Usuario {
	
	private String nome;
	private String telefone;
 	private String email;
	private ArrayList <Item> itens;
	
	public Usuario(String nome,String telefone, String email) {
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
	}

	/**
	 * @return nome do Usuario
	 */
	public String getNome() {
		return this.nome;
	}

	/**
	 * Mudança no nome do Usuario
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
	 * Mudança no telefone do Usuario
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
	 * Mudança no email do Usuario
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return lista de itens de um Usuario
	 */
	public ArrayList<Item> getItens() {
		return this.itens;
	}

	/**
	 * Mudança na lista de itens de um Usuario
	 * @param itens
	 */
	public void setItens(ArrayList<Item> itens) {
		this.itens = itens;
	}

	/* 
	 * toString do Usuario
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.nome + "," + this.email + "," + this.telefone;
	}
	
	
}
