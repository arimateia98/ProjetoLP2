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
		HashSet<Usuario> usuariosCopia = (HashSet<Usuario>) this.usuarios.clone();
		
		if (!usuariosCopia.contains(usuario)){
			throw new NullPointerException("Usuario invalido");
		}
		
		for (Usuario users : usuariosCopia){
			if (users.equals(usuario)) {
				switch (atributo.toLowerCase()){
					case "nome":
						this.usuarios.add(new Usuario(valor ,users.getTelefone(), users.getEmail()));
						this.usuarios.remove(usuario);
					case "telefone":
						this.usuarios.add(new Usuario(users.getNome(), valor, users.getEmail()));
						this.usuarios.remove(usuario);
					case "email":
						users.setEmail(valor);
				}
			}
		}
	}
	
	/**
	 * A partir do nome e telefone, conseguimos o valor do atributo pedido
	 * @param nome
	 * @param telefone
	 * @param atributo
	 * @return atributo pedido
	 */
	public String getInfoUsuario(String nome, String telefone, String atributo){
		Usuario usuario = new Usuario(nome, telefone, "");
		String retorno = "";
		if (usuarios.contains(usuario)){
			for (Usuario users : this.usuarios){
				if (users.equals(usuario)) {
					switch (atributo.toLowerCase()){
						case "nome":
							retorno += users.getNome();
						case "telefone":
							retorno += users.getTelefone();
						case "email":
							retorno += users.getEmail();
					}
				}
			}
		}else{
			throw new NullPointerException("Usuario invalido");
		}
		
		return retorno;
		
	}

	public void cadastrarEletronico(String nome, String telefone, String nomeItem, Double preco, String plataforma) {
		
	}

	public void cadastrarJogoTabuleiro(String nome, String telefone, String nomeItem, Double preco) {
		
	}

	public void adicionarPecaPerdida(String nome, String telefone, String nomeItem, String nomePeca) {
		
	}

	public void cadastrarBluRayFilme(String nome, String telefone, String nomeItem, Double preco, int duracao,
			String classificacao, int anoLancamento) {
		
	}

	public void cadastrarBluRayShow(String nome, String telefone, String nomeItem, Double preco, int duracao,
			int numeroFaixas, String artista, String classificacao) {
		
	}

	public void cadastrarBluRaySerie(String nome, String telefone, String nomeItem, Double preco, String descricao,
			int duracao, String classificacao, String genero, int temporada) {
		
	}

	public void adicionarBluRay(String nome, String telefone, String nomeBlurayTemporada, int duracao) {
		
	}

	public void removerItem(String nome, String telefone, String nomeItem) {
		
	}

	public void atualizarItem(String nome, String telefone, String nomeItem, String atributo, String valor) {
		
	}

	public String getInfoItem(String nome, String telefone, String nomeItem, String atributo) {
		return "";
	}


	
		
	
	
	

}
