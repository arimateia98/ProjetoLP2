package trackingThings;

import java.util.HashSet;

public class Sistema {
	
	private HashSet<Usuario> usuarios;
	
	public Sistema(){
		this.usuarios = new HashSet<>();
	}
		
	/**
	 * Realiza o cadastro de Usuarios
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
	 * Obtem informacao do usuario de acordo com o atributo
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

	/**
	 * Cadastra um jogo eletronico no sistema de emprestimos
	 * 
	 * @param nome
	 * @param telefone
	 * @param nomeItem
	 * @param preco
	 * @param plataforma
	 */
	public void cadastrarEletronico(String nome, String telefone, String nomeItem, Double preco, String plataforma) {
		
	}

	/**
	 * Cadastra um jogo de tabuleiro
	 * @param nome
	 * @param telefone
	 * @param nomeItem
	 * @param preco
	 */
	public void cadastrarJogoTabuleiro(String nome, String telefone, String nomeItem, Double preco) {
		
	}

	/**
	 * Informa ao sistema alguma peça perdida
	 * @param nome
	 * @param telefone
	 * @param nomeItem
	 * @param nomePeca
	 */
	public void adicionarPecaPerdida(String nome, String telefone, String nomeItem, String nomePeca) {
		
	}

	/**
	 * Cadastra filmes Bluray
	 * @param nome
	 * @param telefone
	 * @param nomeItem
	 * @param preco
	 * @param duracao
	 * @param classificacao
	 * @param anoLancamento
	 */
	public void cadastrarBluRayFilme(String nome, String telefone, String nomeItem, Double preco, int duracao,
			String classificacao, int anoLancamento) {
		
	}

	/**
	 * Cadastra Shows Bluray
	 * @param nome
	 * @param telefone
	 * @param nomeItem
	 * @param preco
	 * @param duracao
	 * @param numeroFaixas
	 * @param artista
	 * @param classificacao
	 */
	public void cadastrarBluRayShow(String nome, String telefone, String nomeItem, Double preco, int duracao,
			int numeroFaixas, String artista, String classificacao) {
		
	}

	/**
	 * Cadastra Series Bluray
	 * @param nome
	 * @param telefone
	 * @param nomeItem
	 * @param preco
	 * @param descricao
	 * @param duracao
	 * @param classificacao
	 * @param genero
	 * @param temporada
	 */
	public void cadastrarBluRaySerie(String nome, String telefone, String nomeItem, Double preco, String descricao,
			int duracao, String classificacao, String genero, int temporada) {
		
	}

	/**
	 * ?????
	 * @param nome
	 * @param telefone
	 * @param nomeBlurayTemporada
	 * @param duracao
	 */
	public void adicionarBluRay(String nome, String telefone, String nomeBlurayTemporada, int duracao) {
		
	}

	/**
	 * Remove Item do Sistema
	 * @param nome
	 * @param telefone
	 * @param nomeItem
	 */
	public void removerItem(String nome, String telefone, String nomeItem) {
		
	}

	/**
	 * Atualiza o item de acordo com o atributo pedido
	 * @param nome
	 * @param telefone
	 * @param nomeItem
	 * @param atributo
	 * @param valor
	 */
	public void atualizarItem(String nome, String telefone, String nomeItem, String atributo, String valor) {
		
	}

	/**
	 * Obtem informacoes do item de acordo com o atributo
	 * @param nome
	 * @param telefone
	 * @param nomeItem
	 * @param atributo
	 * @return
	 */
	public String getInfoItem(String nome, String telefone, String nomeItem, String atributo) {
		return "";
	}


	
		
	
	
	

}
