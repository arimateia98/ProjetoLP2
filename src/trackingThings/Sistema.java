package trackingThings;

import java.util.HashSet;

public class Sistema {
	
	private HashSet<Usuario> usuarios;
	
	public Sistema(){
		this.usuarios = new HashSet<>();
	}
		
	/**
	 * Realiza o cadastro de Usuarios ao obter os parametros
	 * @param nome
	 * @param telefone
	 * @param email
	 */
	public void cadastrarUsuario(String nome,String telefone, String email){
		if (nome.equals(null) || nome.trim().equals("")) {
			throw new NullPointerException("Usuario invalido: Nome nao pode ser vazio");
		}
		if (telefone.equals(null) || telefone.trim().equals("")) {
			throw new NullPointerException("Usuario invalido: Telefone nao pode ser vazio");
		}
		if (email.equals(null) || email.trim().equals("")) {
			throw new NullPointerException("Usuario invalido: Email nao pode ser vazio");
		}
		if (this.usuarios.contains(new Usuario(nome, telefone, email))) {
			throw new NullPointerException("Usuario ja cadastrado");
		}
		
		this.usuarios.add(new Usuario(nome, telefone, email));
	}
	
	/**
	 * Remove Usuario do sistema
	 * @param nome
	 * @param telefone
	 */
	public void removerUsuario(String nome, String telefone){
		if (nome.equals(null) || nome.trim().equals("")) {
			throw new NullPointerException("Usuario invalido: Nome nao pode ser vazio");
		}
		if (telefone.equals(null) || telefone.trim().equals("")) {
			throw new NullPointerException("Usuario invalido: Telefone nao pode ser vazio");
		}
		
		Usuario usuario = new Usuario(nome, telefone, "");
		if (usuarios.contains(usuario)){
			this.usuarios.remove(usuario);
		}else{
			throw new NullPointerException("Usuario invalido");
		}
	
	}
	
	/**
	 * Realiza a alteracao de algum dado do usuario a partir da variavel "atributo"
	 * @param nome
	 * @param telefone
	 * @param atributo
	 * @param valor
	 */
	public void atualizarUsuario(String nome, String telefone, String atributo, String valor){
		if (nome.equals(null) || nome.trim().equals("")) {
			throw new NullPointerException("Usuario invalido: Nome nao pode ser vazio");
		}
		
		if (telefone.equals(null) || telefone.trim().equals("")) {
			throw new NullPointerException("Usuario invalido: Telefone nao pode ser vazio");
		}
		if (valor.equals(null) || valor.trim().equals("")) {
			throw new NullPointerException("Usuario invalido: Valor nao pode ser vazio");
		}
		if (atributo.equals(null) || atributo.trim().equals("")) {
			throw new NullPointerException("Usuario invalido: Atributo nao pode ser vazio");
		}
		
		Usuario usuario = new Usuario(nome, telefone, "");
		if (usuarios.contains(usuario)){
			for (Usuario users : this.usuarios){
				if (users.equals(usuario)) {
					switch (atributo.toLowerCase()){
						case "nome":
							users.setNome(valor);
						case "telefone":
							users.setTelefone(valor);
						case "email":
							users.setEmail(valor);
					}
				}
			}
		}else{
			throw new NullPointerException("Usuario invalido");
		}
	}
	

}
