package trackingThings;


public class Facade {
	
	Sistema sistema;
	
	public void iniciarSistema() {
		this.sistema = new Sistema();
	}
	
	public void cadastrarUsuario(String nome,String telefone, String email){
		this.sistema.cadastrarUsuario(nome, telefone, email);
	}
	
	public void removerUsuario(String nome, String telefone){
		this.sistema.removerUsuario(nome, telefone);
	}
	
	public void atualizarUsuario(String nome,String telefone, String atributo, String valor){
		this.sistema.atualizarUsuario(nome, telefone, atributo, valor);
	}
	
	public String getInfoUsuario(String nome, String telefone, String atributo){
		return this.sistema.getInfoUsuario(nome, telefone, atributo);
	}
	
	public void cadastrarEletronico(String nome, String telefone, String nomeItem, Double preco, String plataforma){
		this.sistema.cadastrarEletronico(nome, telefone, nomeItem, preco, plataforma);
	}
	
	public void cadastrarJogoTabuleiro(String nome, String telefone, String nomeItem, Double preco){
		this.sistema.cadastrarJogoTabuleiro(nome, telefone, nomeItem, preco);
	}
	
	public void adicionarPecaPerdida(String nome, String telefone, String nomeItem, String nomePeca){
		this.sistema.adicionarPecaPerdida(nome, telefone, nomeItem, nomePeca);
	}
	
	public void cadastrarBluRayFilme(String nome, String telefone, String nomeItem, Double preco, int duracao, String genero, String classificacao, int anoLancamento ){
		this.sistema.cadastrarBluRayFilme(nome, telefone, nomeItem, preco, duracao, genero, classificacao, anoLancamento);
	}
	
	public void cadastrarBluRayShow(String nome, String telefone, String nomeItem, Double preco, int duracao, int numeroFaixas, String artista, String classificacao){
		this.sistema.cadastrarBluRayShow(nome, telefone, nomeItem, preco, duracao, numeroFaixas, artista, classificacao);
	}

	public void cadastrarBluRaySerie(String nome, String telefone, String nomeItem, Double preco, String descricao, int duracao, String classificacao, String genero, int temporada){
		this.sistema.cadastrarBluRaySerie(nome, telefone, nomeItem, preco, descricao, duracao, classificacao, genero, temporada);
	}
	
	public void adicionarBluRay(String nome, String telefone, String nomeBlurayTemporada, int duracao){
		this.sistema.adicionarBluRay(nome, telefone, nomeBlurayTemporada, duracao);
	}

	public void removerItem(String nome, String telefone, String nomeItem){
		this.sistema.removerItem(nome, telefone, nomeItem);
	}
	
	public void atualizarItem(String nome, String telefone, String nomeItem, String atributo, String valor){
		this.sistema.atualizarItem(nome, telefone, nomeItem, atributo, valor);
	}
	
	public String getInfoItem(String nome, String telefone, String nomeItem, String atributo){
		return this.sistema.getInfoItem(nome, telefone, nomeItem, atributo);
	}
	
	public String listarItensOrdenadosPorNome(){
		return this.sistema.listarItensOrdenadosPorNome();
	}
	
	public String listarItensOrdenadosPorValor(){
		return this.sistema.listarItensOrdenadosPorValor();
	}
	
	public String pesquisarDetalhesItem(String nome, String telefone, String nomeItem){
		return this.sistema.pesquisarDetalhesItem(nome, telefone, nomeItem);
	}
	
	public void registrarEmprestimo(String nomeDono, String telefoneDono, String nomeReferente, String telefoneReferente, String nomeItem, String dataEmprestimo, int periodo){
		this.sistema.registrarEmprestimo(nomeDono, telefoneDono, nomeReferente, telefoneReferente, nomeItem, dataEmprestimo, periodo);
	}
	
	public void devolverItem(String nomeDono, String telefoneDono, String nomeReferente, String telefoneReferente, String nomeItem, String dataEmprestimo, String dataDevolucao){
		this.sistema.devolverItem(nomeDono, telefoneDono, nomeReferente, telefoneReferente, nomeItem, dataEmprestimo, dataDevolucao);
	}
	
	public void fecharSistema(){
		
	}

}