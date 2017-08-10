package testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import trackingThings.*;

public class SistemaTest {
	
	Sistema sistema;

	@Before
	public void setUp() throws Exception {
		
		sistema = new Sistema();
		sistema.cadastrarUsuario("Arizinho", "9900-6660","arizinho100%lindo@bol.com.br");
		sistema.cadastrarUsuario("Ramones", "9955-2222","ramon100%cancer@gmail.com");
		sistema.cadastrarUsuario("zezinho", "9988-8889", "zevinicin@yahoo.com.br");
		sistema.cadastrarUsuario("katiau", "9912-3456","katiau@gmail.com");
		// Adicionando para Arizinho 9900-6660
		sistema.cadastrarBluRayFilme("Arizinho", "9900-6660", nomeItem, preco, duracao, genero, classificacao, anoLancamento);
		sistema.cadastrarBluRaySerie(nome, telefone, nomeItem, preco, descricao, duracao, classificacao, genero, temporada);
		sistema.cadastrarBluRayShow(nome, telefone, nomeItem, preco, duracao, numeroFaixas, artista, classificacao);
		sistema.cadastrarJogoTabuleiro(, telefone, nomeItem, preco);
		sistema.cadastrarEletronico(nome, telefone, nomeItem, preco, plataforma);
		// Adicionando para Ramones 9955-2222
	}
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
