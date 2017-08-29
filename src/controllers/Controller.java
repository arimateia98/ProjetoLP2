package controllers;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import comparators.EmprestimosComparator;
import comparators.NomeComparator;
import comparators.ReputacaoComparator;
import comparators.ReputacaoInversoComparator;
import comparators.ValorComparator;
import itens.Item;
import keys.EmprestimoKey;
import keys.UsuarioKey;
import trackingThings.Emprestimo;
import trackingThings.Usuario;

/**
 * @author Katson Matheus
 *
 */
public class Controller implements Serializable{
	
	private HashMap<UsuarioKey, Usuario> usuarios;
	private ControllerEmprestimo sistemaEmprestimo;
	
	public Controller(){
		this.usuarios = new HashMap<>();
		this.sistemaEmprestimo = new ControllerEmprestimo();
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
	 * @return atributo do usuario
	 */
	public String getInfoUsuario(String nome, String telefone, String atributo){
		UsuarioKey usuarioKey = new UsuarioKey(nome, telefone);
		if (!usuarios.containsKey(usuarioKey)){
			throw new NullPointerException("Usuario invalido");
		}
		if (atributo.equalsIgnoreCase("nome")) {
			return this.usuarios.get(usuarioKey).getNome();
		}
		if (atributo.equalsIgnoreCase("telefone")) {
			return this.usuarios.get(usuarioKey).getTelefone();
		}
		if (atributo.equalsIgnoreCase("email")) {
			return this.usuarios.get(usuarioKey).getEmail();
		}
		if (atributo.equalsIgnoreCase("reputacao")) {
			return ""+this.usuarios.get(usuarioKey).getReputacao();
		}
		if (atributo.equalsIgnoreCase("cartao")) {
			return this.usuarios.get(usuarioKey).getCartao().toString();
		}
		else{
			throw new NullPointerException("Atributo invalido");
		}
		
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
		this.usuarios.get(usuarioKey).cadastrarEletronico(nomeItem, preco, plataforma);
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
		if (!usuarios.containsKey(usuarioKey)){
			throw new NullPointerException("Usuario invalido");
		}
		if (preco <= 0){
			throw new NullPointerException("Preco invalido");
		}
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
	 * @param genero
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
	 * Adiciona um Bluray
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
		if (!usuarios.containsKey(usuarioKey)){
			throw new NullPointerException("Usuario invalido");
		}
		if (!usuarios.get(usuarioKey).verificaSeItemExiste(nomeItem)){
			throw new NullPointerException("Item nao encontrado");
		}
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
		if (!usuarios.containsKey(usuarioKey)){
			throw new NullPointerException("Usuario invalido");
		}
		if (!usuarios.get(usuarioKey).verificaSeItemExiste(nomeItem)){
			throw new NullPointerException("Item nao encontrado");
		}
		usuarios.get(usuarioKey).atualizarItem(nomeItem, atributo, valor);
	}

	/**
	 * Obtem informacoes do item de acordo com o atributo
	 * @param nome
	 * @param telefone
	 * @param nomeItem
	 * @param atributo
	 * @return atributo do item
	 */
	public String getInfoItem(String nome, String telefone, String nomeItem, String atributo) {
		UsuarioKey usuarioKey = new UsuarioKey(nome, telefone);

		if (!this.usuarios.get(usuarioKey).verificaSeItemExiste(nomeItem)) {
			throw new NullPointerException("Item nao encontrado");
		}
		return usuarios.get(usuarioKey).getInfoItem(nomeItem, atributo);
	}
	
	/**
	 * Verifica a existencia do usuario no sistema
	 * @param nome
	 * @param telefone
	 * @return true or false
	 */
	public boolean verificaSeUsuarioExiste(String nome, String telefone) {
		UsuarioKey usuario = new UsuarioKey(nome, telefone);
		if (this.usuarios.containsKey(usuario)) { 
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Lista os itens ordenados pelo nome
	 * @return itens ordenados
	 */
	public String listarItensOrdenadosPorNome() {
		ArrayList<Item> todosItens = new ArrayList<>();
		
		for (Usuario usuario : usuarios.values()){
			todosItens.addAll(usuario.getItensPossuidos().values());
		}
		
		Collections.sort(todosItens, new NomeComparator());
		String retorno = "";
		for (Item item : todosItens){
			retorno += item.toString()+"|";
		}
		return retorno;
	}

	/**
	 * Lista os itens ordenados pelo seu valor
	 * @return itens ordenados
	 */
	public String listarItensOrdenadosPorValor() {
		ArrayList<Item> todosItens = new ArrayList<>();

		for (Usuario usuario : usuarios.values()){
			todosItens.addAll(usuario.getItensPossuidos().values());
		}
		
		Collections.sort(todosItens, new ValorComparator());
		String retorno = "";
		for (Item item : todosItens){
			retorno += item.toString()+"|";
		}
		return retorno;
	}

	/**
	 * Pesquisa detalhes dos itens
	 * @param nome
	 * @param telefone
	 * @param nomeItem
	 * @return
	 */
	public String pesquisarDetalhesItem(String nome, String telefone, String nomeItem) {
		
		UsuarioKey usuarioKey = new UsuarioKey(nome, telefone);
		if (!usuarios.containsKey(usuarioKey)){
			throw new NullPointerException("Usuario invalido");
		}
		if (!usuarios.get(usuarioKey).verificaSeItemExiste(nomeItem)){
			throw new NullPointerException("Item nao encontrado");
		}
		return usuarios.get(usuarioKey).detalhesItem(nomeItem);
	}

	/**
	 * Registra um emprestimo, no qual teremos os dados do dono e do referente
	 * @param nomeDono
	 * @param telefoneDono
	 * @param nomeReferente
	 * @param telefoneReferente
	 * @param dataEmprestimo
	 * @param nomeItem 
	 * @param periodo
	 */
	public void registrarEmprestimo(String nomeDono, String telefoneDono, String nomeReferente,
		String telefoneReferente, String nomeItem, String dataEmprestimo, int periodo) {
		UsuarioKey usuarioKey1 = new UsuarioKey(nomeDono, telefoneDono);
		UsuarioKey usuarioKey2 = new UsuarioKey(nomeReferente, telefoneReferente);
		if (!usuarios.containsKey(usuarioKey1) || !usuarios.containsKey(usuarioKey2)){
			throw new NullPointerException("Usuario invalido");
		}
		EmprestimoKey emprestimoKey = new EmprestimoKey(usuarios.get(usuarioKey1), usuarios.get(usuarioKey2), usuarios.get(usuarioKey1).getItem(nomeItem));
		if (sistemaEmprestimo.getEmprestimos().containsKey(emprestimoKey)){
			throw new IllegalArgumentException("Emprestimo ja existe");
		}
		if (usuarios.get(usuarioKey1).getItensEmprestados().contains(usuarios.get(usuarioKey1).getItem(nomeItem))) {
			throw new IllegalArgumentException("Item emprestado no momento");
		}
		if (!usuarios.get(usuarioKey1).getItensPossuidos().containsValue(usuarios.get(usuarioKey1).getItem(nomeItem))) {
			throw new IllegalArgumentException("Item nao encontrado");
		}
		if(periodo > usuarios.get(usuarioKey2).getCartao().diasPermitidos()){
			throw new IllegalArgumentException("Usuario impossiblitado de pegar emprestado por esse periodo");
		}
		this.sistemaEmprestimo.registrarEmprestimo(usuarios.get(usuarioKey1), usuarios.get(usuarioKey2),
				usuarios.get(usuarioKey1).getItem(nomeItem), dataEmprestimo, periodo);
	}

	/**
	 * Registra a devolucao do item
	 * @param nomeDono
	 * @param telefoneDono
	 * @param nomeReferente
	 * @param telefoneReferente
	 * @param dataEmprestimo
	 * @param nomeItem
	 * @param dataDevolucao
	 */
	public void devolverItem(String nomeDono, String telefoneDono, String nomeReferente, String telefoneReferente,
			String nomeItem, String dataEmprestimo, String dataDevolucao) {
		
		UsuarioKey usuarioKey1 = new UsuarioKey(nomeDono, telefoneDono);
		UsuarioKey usuarioKey2 = new UsuarioKey(nomeReferente, telefoneReferente);
		
		if (!usuarios.containsKey(usuarioKey1) || !usuarios.containsKey(usuarioKey2)){
			throw new NullPointerException("Usuario invalido");
		}
		
		this.sistemaEmprestimo.devolverItem(usuarios.get(usuarioKey1), usuarios.get(usuarioKey2),
				usuarios.get(usuarioKey1).getItem(nomeItem), dataEmprestimo, dataDevolucao);
	}

	/**
	 * Lista os itens emprestados do usuario
	 * @param nome
	 * @param telefone
	 * @return itens emprestados do usuario
	 */
	public String listarEmprestimosUsuarioEmprestando(String nome, String telefone) {
		UsuarioKey usuariokey = new UsuarioKey(nome, telefone);
		if (!usuarios.containsKey(usuariokey)){
			throw new NullPointerException("Usuario invalido");
		}
		String retorno = "Emprestimos: ";
		for (int i = 0; i < usuarios.get(usuariokey).getEmprestando().size(); i++) {
			retorno += usuarios.get(usuariokey).getEmprestando().get(i).toString() + "|";
		}
		if (retorno.equals("Emprestimos: ")) {
			retorno = "Nenhum item emprestado";

		}
		
		return retorno;
	}

	/**
	 * Lista os itens pegos emprestados pelo usuario
	 * @param nome
	 * @param telefone
	 * @return itens pegos emprestados pelo usuario
	 */
	public String listarEmprestimosUsuarioPegandoEmprestado(String nome, String telefone) {
		UsuarioKey usuariokey = new UsuarioKey(nome, telefone);
		String retorno = "Emprestimos pegos: ";
		if (!usuarios.containsKey(usuariokey)){
			throw new NullPointerException("Usuario invalido");
		}
		for (Emprestimo emprestimo : usuarios.get(usuariokey).getEmprestimosPego()) {
			retorno += emprestimo.toString()+ "|";
		}
		if (retorno.equals("Emprestimos pegos: ")) {
			retorno = "Nenhum item pego emprestado";

		}
		
		return retorno;
	}

	/**
	 * Lista todos os emprestimos do item
	 * @param nomeItem
	 * @return todos os emprestimos do item ocorridos
	 */
	public String listarEmprestimosItem(String nomeItem) {
		String retorno = "Emprestimos associados ao item: ";
		for(Usuario usuario: usuarios.values()){
			if (!usuario.getItensPossuidos().isEmpty()){
				if (usuario.getItensPossuidos().containsKey(nomeItem)) {
					for(Emprestimo emprestimo: usuario.getItem(nomeItem).getEmprestimosOcorridos()){
						retorno += emprestimo.toString() + "|";
					}
				}
			}
		}
		if (retorno.equals("Emprestimos associados ao item: ")){
			return "Nenhum emprestimo associado ao item";
		}
		return retorno;
	}
	/**
	 * Lista todos os itens nao emprestados
	 * @return itens nao emprestados
	 */
	public String listarItensNaoEmprestados() {
		String retorno = "";
		ArrayList<Item> todosItens = new ArrayList<>();

		for (Usuario usuario : usuarios.values()){
			todosItens.addAll(usuario.getItensPossuidos().values());
		}
		Collections.sort(todosItens, new NomeComparator());
		for (Item item: todosItens) {
			if (!item.getEstadoEmprestimo()) {
				retorno += item.toString() + "|";
			}
		}
		return retorno;
	}

	/**
	 * Lista todos os itens emprestados 
	 * @return itens emprestados
	 */
	public String listarItensEmprestados() {
		String retorno = "";
		ArrayList<Item> todosItens = new ArrayList<>();

		for (Usuario usuario : usuarios.values()){
			todosItens.addAll(usuario.getItensPossuidos().values());
		}
		Collections.sort(todosItens, new NomeComparator());
		for (Item item: todosItens) {
			if (item.getEstadoEmprestimo()) {
				retorno += "Dono do item: " + item.getDonoItem() + ", Nome do item emprestado: " + item.getNome() + "|";
			}
		}
		return retorno;
	}

	/**
	 * Lista os 10 itens mais emprestados
	 * @return 10 itens mais emprestados
	 */
	public String listarTop10Itens() {
		String retorno = "";
		ArrayList<Item> todosItem = new ArrayList<>();
		for (Usuario usuario : usuarios.values()){
			todosItem.addAll(usuario.getItensPossuidos().values());
		}
		Collections.sort(todosItem, new EmprestimosComparator());
		for (int i = 0; i < todosItem.size() && i < 10; i++) {
			if (todosItem.get(i).getEmprestimosOcorridos().size() > 0) {
				retorno += (i+1) + ") " + todosItem.get(i).getEmprestimosOcorridos().size() + " emprestimos - "+ 
		todosItem.get(i).toString() + "|" ;
			}
		}
		return retorno;
	}
	
	/**
	 * Lista usuarios caloteiros
	 * @return lista de usuarios com cartao "caloteiro"
	 */
	public String listarCaloteiros() {
		String retorno = "Lista de usuarios com reputacao negativa: ";
		for (Usuario usuario: usuarios.values()) {
			if(usuario.getReputacao() < 0.00) {
				retorno += usuario.toString() + "|";
			}
		}
		return retorno;
	}

	/**
	 * Lista os 10 usuarios com melhor reputacao
	 * @return lista dos 10 melhores usuarios
	 */
	public String listarTop10MelhoresUsuarios() {
		String retorno = "";
		ArrayList<Usuario> todosUsuarios = new ArrayList<>();
		for (Usuario usuario : usuarios.values()){
			todosUsuarios.add(usuario);
		}
		Collections.sort(todosUsuarios, new ReputacaoComparator());
		for (int i = 0; i < 10; i++) {
			String resultado = String.format("%.2f", todosUsuarios.get(i).getReputacao());
			retorno += (i+1) + ": " + todosUsuarios.get(i).getNome() + " - Reputacao: "+ resultado + "|" ;
		}
		return retorno;
	}

	/**
	 * Lista os 10 usuarios com a pior reputacao
	 * @return lista dos 10 piores usuarios
	 */
	public String listarTop10PioresUsuarios() {
		String retorno = "";
		ArrayList<Usuario> todosUsuarios = new ArrayList<>();
		for (Usuario usuario : usuarios.values()){
			todosUsuarios.add(usuario);
		}
		Collections.sort(todosUsuarios, new ReputacaoInversoComparator());
		for (int i = 0; i < 10; i++) {
			String resultado = String.format("%.2f", todosUsuarios.get(i).getReputacao());
			retorno += (i+1) + ": " + todosUsuarios.get(i).getNome() + " - Reputacao: "+ resultado + "|" ;
		}
		return retorno;
	}

	public void iniciarSistema() throws FileNotFoundException, IOException, ClassNotFoundException {

		this.sistemaEmprestimo.lerEmprestimos();
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("usuarios.txt"));
		try {
			while(true) {
				
				Usuario user = (Usuario) ois.readObject();
				usuarios.put(new UsuarioKey(user.getNome(), user.getTelefone()),user);
			}
		}
		catch(EOFException e) {
			
		}
		
		ois.close();
	}

	public void fecharSistema() {
		
		sistemaEmprestimo.salvarEmprestimos();
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream("usuarios.txt"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(Usuario	usuario : usuarios.values()) {
			try {
				oos.writeObject(usuario);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	
}
