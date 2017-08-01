package trackingThings;

import java.util.ArrayList;

public class Sistema {
	private ArrayList<Usuario> usuarios;
	private UsuarioComparator comparar;
	public Sistema(){
		comparar = new UsuarioComparator();
	}
	
	/**
	 * Realiza o cadastro de Usuarios ao obter os parametros
	 * @param nome
	 * @param telefone
	 * @param email
	 */
	public void cadastrarUsuario(String nome,String telefone, String email){
		if (nome.equals(null) || nome.trim().equals("")) {
			NullPointerException nomeInvalido = new NullPointerException("Usuario invalido: Nome nao pode ser vazio");
			throw nomeInvalido;
		}
		if (telefone.equals(null) || telefone.trim().equals("")) {
			NullPointerException telefoneInvalido = new NullPointerException("Usuario invalido: Telefone nao pode ser vazio");
			throw telefoneInvalido;
		}
		if (email.equals(null) || email.trim().equals("")) {
			NullPointerException emailInvalido = new NullPointerException("Usuario invalido: Email nao pode ser vazio");
			throw emailInvalido;
		}
		if (usuarios.contains(new Usuario(nome, telefone, email))) {
			NullPointerException usuarioInvalido = new NullPointerException("Usuario ja cadastrado");
			throw usuarioInvalido;
		}
		usuarios.add(new Usuario(nome, telefone, email));
	}
	
	/**
	 * Remove Usuario do sistema
	 * @param nome
	 * @param telefone
	 */
	public void removerUsuario(String nome, String telefone){
		if (nome.equals(null) || nome.trim().equals("")) {
			NullPointerException nomeInvalido = new NullPointerException("Usuario invalido: Nome nao pode ser vazio");
			throw nomeInvalido;
		}
		if (telefone.equals(null) || telefone.trim().equals("")) {
			NullPointerException telefoneInvalido = new NullPointerException("Usuario invalido: Telefone nao pode ser vazio");
			throw telefoneInvalido;
		}
	
		for (int i = 0; i < usuarios.size(); i++) {
			if (comparar.compare(usuarios.get(i), new Usuario(nome, telefone, "")) == 1) {
				usuarios.remove(i);
			}
		
		}
	}
	
	/**
	 * Realiza a alteração de algum dado do usuario a partir da variavel "atributo"
	 * @param nome
	 * @param telefone
	 * @param atributo
	 * @param email
	 */
	public void atualizarUsuario(String nome,String telefone, String atributo, String email){
		if (nome.equals(null) || nome.trim().equals("")) {
			NullPointerException nomeInvalido = new NullPointerException("Usuario invalido: Nome nao pode ser vazio");
			throw nomeInvalido;
		}
		// falta condicao para o caso do usuario nao estiver no sistema
		
		if (telefone.equals(null) || telefone.trim().equals("")) {
			NullPointerException telefoneInvalido = new NullPointerException("Usuario invalido: Telefone nao pode ser vazio");
			throw telefoneInvalido;
		}
		if (email.equals(null) || email.trim().equals("")) {
			NullPointerException emailInvalido = new NullPointerException("Usuario invalido: Email nao pode ser vazio");
			throw emailInvalido;
		}
		if (atributo.equals(null) || atributo.trim().equals("")) {
			NullPointerException atributoInvalido = new NullPointerException("Usuario invalido: Email nao pode ser vazio");
			throw atributoInvalido;
		}
		
		switch (atributo) {
			case "nome":
				// vai dar o set em usuario
				usuarios.get(0).setNome(nome);
			case "telefone":
				usuarios.get(0).setTelefone(telefone);
			case "email":
				usuarios.get(0).setEmail(email);
			
		}
	}

}
