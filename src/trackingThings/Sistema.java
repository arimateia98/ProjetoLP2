package trackingThings;

public class Sistema {
	Usuario usuario;
	
	public Sistema(){
		
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
		
	}
	
	/**
	 * Remove Usuario do sistema
	 * @param nome
	 * @param telefone
	 */
	public void removerUsuario(String nome, String telefone){
		
	}
	
	/**
	 * Realiza a alteração de algum dado do usuario a partir da variavel "atributo"
	 * @param nome
	 * @param telefone
	 * @param atributo
	 * @param email
	 */
	public void atualizarUsuario(String nome,String telefone, String atributo, String email){
		
	}

}
