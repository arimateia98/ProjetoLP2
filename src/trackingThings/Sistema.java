package trackingThings;

import java.util.HashMap;

public class Sistema {
	
	private HashMap<UsuarioKey, Usuario> usuarios;
	private SistemaEmprestimo sistemaEmprestimo;
	
	
	public Sistema(){
		this.usuarios = new HashMap<>();
		this.sistemaEmprestimo = new SistemaEmprestimo();
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
		if (this.usuarios.containsKey(new UsuarioKey(nome, telefone))) {
			throw new NullPointerException("Usuario ja cadastrado");
		}
		
		this.usuarios.put((new UsuarioKey(nome, telefone)),new Usuario(nome, telefone, email));
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
		
		UsuarioKey usuarioKey = new UsuarioKey(nome, telefone);
		if (usuarios.containsKey(usuarioKey)){
			this.usuarios.remove(usuarioKey);
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
		
		UsuarioKey usuarioKey = new UsuarioKey(nome, telefone);
		
		if (!usuarios.containsKey(usuarioKey)){
			throw new NullPointerException("Usuario invalido");
		}
		
		if (atributo.toLowerCase().equals("nome")){
				this.usuarios.put(new UsuarioKey(valor, telefone), new Usuario(valor, telefone, this.usuarios.get(usuarioKey).getEmail()));
				usuarios.remove(usuarioKey);
		}	
		else if (atributo.toLowerCase().equals("telefone")){
				this.usuarios.put(new UsuarioKey(nome, valor), new Usuario(nome, valor, this.usuarios.get(usuarioKey).getEmail()));
				usuarios.remove(usuarioKey);
		}
		else if  (atributo.toLowerCase().equals("email")){
				this.usuarios.get(usuarioKey).setEmail(valor);
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
		UsuarioKey usuarioKey = new UsuarioKey(nome, telefone);
		String retorno = "";
		if (!usuarios.containsKey(usuarioKey)){
			throw new NullPointerException("Usuario invalido");
		}
		
		switch (atributo.toLowerCase()){
				case "nome":
					retorno += usuarios.get(usuarioKey).getNome();
				case "telefone":
					retorno += usuarios.get(usuarioKey).getTelefone();
				case "email":
					retorno += usuarios.get(usuarioKey).getEmail();
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
		UsuarioKey usuarioKey = new UsuarioKey(nome, telefone);
		usuarios.get(usuarioKey).cadastrarEletronico(nomeItem, preco, plataforma);
	}

	/**
	 * Cadastra um jogo de tabuleiro
	 * @param nome
	 * @param telefone
	 * @param nomeItem
	 * @param preco
	 */
	public void cadastrarJogoTabuleiro(String nome, String telefone, String nomeItem, Double preco) {
		UsuarioKey usuarioKey = new UsuarioKey(nome, telefone);
		usuarios.get(usuarioKey).cadastrarJogoTabuleiro(nomeItem, preco);
	}

	/**
	 * Informa ao sistema alguma peca perdida
	 * @param nome
	 * @param telefone
	 * @param nomeItem
	 * @param nomePeca
	 */
	public void adicionarPecaPerdida(String nome, String telefone, String nomeItem, String nomePeca) {
		UsuarioKey usuarioKey = new UsuarioKey(nome, telefone);
		usuarios.get(usuarioKey).adicionarPecaPerdida(nomeItem, nomePeca);
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
	public void cadastrarBluRayFilme(String nome, String telefone, String nomeItem, Double preco, int duracao, String genero,
			String classificacao, int anoLancamento) {
		UsuarioKey usuarioKey = new UsuarioKey(nome, telefone);
		usuarios.get(usuarioKey).cadastrarBluRayFilme(nomeItem, preco, duracao, genero, classificacao, anoLancamento);
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
		UsuarioKey usuarioKey = new UsuarioKey(nome, telefone);
		usuarios.get(usuarioKey).cadastrarBluRayShow(nomeItem, preco, duracao, numeroFaixas, artista, classificacao);
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
		UsuarioKey usuarioKey = new UsuarioKey(nome, telefone);
		usuarios.get(usuarioKey).cadastrarBluRaySerie(nomeItem, preco, descricao, duracao, 
				classificacao, genero, temporada);
	}

	/**
	 * ?????
	 * @param nome
	 * @param telefone
	 * @param nomeBlurayTemporada
	 * @param duracao
	 */
	public void adicionarBluRay(String nome, String telefone, String nomeBlurayTemporada, int duracao) {
		UsuarioKey usuarioKey = new UsuarioKey(nome, telefone);
		usuarios.get(usuarioKey).adicionarBluRay(nomeBlurayTemporada, duracao);
	}

	/**
	 * Remove Item do Sistema
	 * @param nome
	 * @param telefone
	 * @param nomeItem
	 */
	public void removerItem(String nome, String telefone, String nomeItem) {
		UsuarioKey usuarioKey = new UsuarioKey(nome, telefone);
		usuarios.get(usuarioKey).removerItem(nomeItem);
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
		UsuarioKey usuarioKey = new UsuarioKey(nome, telefone);
		usuarios.get(usuarioKey).atualizarItem(nomeItem, atributo, valor);
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
		UsuarioKey usuarioKey = new UsuarioKey(nome, telefone);
		return usuarios.get(usuarioKey).getInfoItem(nomeItem);
	}

	
}
