package testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import controllers.Controller;
import trackingThings.*;

public class ControllerTest {
	
	Controller sistema;

	@Before
	public void setUp() throws Exception {
		
		sistema = new Controller();
		sistema.cadastrarUsuario("Arizinho", "9900-6660","arizinho100%lindo@bol.com.br");
		sistema.cadastrarUsuario("Ramones", "9955-2222","ramon100%cancer@gmail.com");
		sistema.cadastrarUsuario("zezinho", "9988-8889", "zevinicin@yahoo.com.br");
		sistema.cadastrarUsuario("katiau", "9912-3456","katiau@gmail.com");
		// Adicionando para Arizinho 9900-6660
		sistema.cadastrarBluRayFilme("Arizinho", "9900-6660", "X-men", 29.99, 120, "Acao", "DEZESSEIS_ANOS", 2002);
		sistema.cadastrarBluRaySerie("Arizinho", "9900-6660", "The Walking Dead", 25.50, "zumbis", 160, "DOZE_ANOS", "Suspense", 2);
		sistema.cadastrarBluRayShow("Arizinho", "9900-6660", "RBD", 45.99, 90, 15, "REBELDES", "DOZE_ANOS");
		sistema.cadastrarJogoTabuleiro("Arizinho", "9900-6660", "damas", 0.99);
		sistema.cadastrarEletronico("Arizinho", "9900-6660", "Mario bros", 1.25, "NINTENDO");
		// Adicionando para Ramones 9955-2222
		sistema.cadastrarBluRayFilme("Ramones", "9955-2222", "Pirata dos caribes", 50.00, 120, "Acao", "DEZESSEIS_ANOS", 2015);
		sistema.cadastrarBluRaySerie("Ramones", "9955-2222", "Game of Thrones", 35.00, "lutas epicas", 180, "DEZESSEIS_ANOS", "Suspense", 6);
		sistema.cadastrarBluRayShow("Ramones", "9955-2222", "LS", 99.00, 90, 15, "Luan Santana", "DEZ_ANOS");
		sistema.cadastrarJogoTabuleiro("Ramones", "9955-2222", "xadrez", 100.00);
		sistema.cadastrarEletronico("Ramones", "9955-2222", "mario world", 1.00, "NINTENDO");
		// Adicionando para zezinho 9988-8889
		sistema.cadastrarBluRayFilme("zezinho", "9988-8889", "Brasileirinhas", 69.00, 60, "EROTICO", "DEZOITO_ANOS", 2013);
		sistema.cadastrarBluRaySerie("zezinho", "9988-8889", "Vikings", 99.00, "mitologia nordica", 120, "DOZE_ANOS", "Suspense", 3);
		sistema.cadastrarBluRayShow("zezinho", "9988-8889", "Los Hermanos", 99.00, 90, 15, "Losers manos", "LIVRE");
		sistema.cadastrarJogoTabuleiro("zezinho", "9988-8889", "Django", 24.00);
		sistema.cadastrarEletronico("zezinho", "9988-8889", "sonic", 1.00, "MEGA DRIVE");
		// Adicionando para katiau 9912-3456
		sistema.cadastrarBluRayFilme("katiau", "9912-3456", "Simpsons XXX", 50.00, 120, "EROTICO", "DEZOITO_ANOS", 2000);
		sistema.cadastrarBluRaySerie("katiau", "9912-3456", "Mr Robot", 86.00, "hacker", 160, "DEZESSEIS_ANOS", "Drama", 2);
		sistema.cadastrarBluRayShow("katiau", "9912-3456", "Ramones", 10.00, 60, 5, "Ramonetmal", "DEZ_ANOS");
		sistema.cadastrarJogoTabuleiro("katiau", "9912-3456", "War", 120.00);
		sistema.cadastrarEletronico("katiau", "9912-3456", "Bomba Patch", 1.00, "PS2");
						
				
	}
	
	@Test
	public void testGetInfoUsuario() {
		assertEquals(sistema.getInfoUsuario("Arizinho", "9900-6660", "nome"), "Arizinho");
		assertEquals(sistema.getInfoUsuario("Arizinho", "9900-6660", "telefone"),"9900-6660");
		assertEquals(sistema.getInfoUsuario("Arizinho", "9900-6660", "email"), "arizinho100%lindo@bol.com.br");
		assertEquals(sistema.getInfoUsuario("Ramones", "9955-2222", "nome"), "Ramones");
		assertEquals(sistema.getInfoUsuario("Ramones", "9955-2222", "telefone"),"9955-2222");
		assertEquals(sistema.getInfoUsuario("Ramones", "9955-2222", "email"), "ramon100%cancer@gmail.com");
		assertEquals(sistema.getInfoUsuario("zezinho", "9988-8889", "nome"), "zezinho");
		assertEquals(sistema.getInfoUsuario("zezinho", "9988-8889", "telefone"),"9988-8889");
		assertEquals(sistema.getInfoUsuario("zezinho", "9988-8889", "email"), "zevinicin@yahoo.com.br");
		assertEquals(sistema.getInfoUsuario("katiau", "9912-3456", "nome"), "katiau");
		assertEquals(sistema.getInfoUsuario("katiau", "9912-3456", "telefone"),"9912-3456");
		assertEquals(sistema.getInfoUsuario("katiau", "9912-3456", "email"), "katiau@gmail.com");
		
	}
	
	@Test
	public void testGetInfoItem() {
		assertEquals(sistema.getInfoItem("Arizinho", "9900-6660", "damas", "nome"), "damas");
		assertEquals(sistema.getInfoItem("Arizinho", "9900-6660", "damas", "preco"), "0.99");		
		assertEquals(sistema.getInfoItem("Ramones", "9955-2222", "mario world", "nome"), "mario world");
		assertEquals(sistema.getInfoItem("Ramones", "9955-2222", "mario world", "preco"), "1.0");		
		assertEquals(sistema.getInfoItem("zezinho", "9988-8889", "Los Hermanos", "nome"), "Los Hermanos");
		assertEquals(sistema.getInfoItem("zezinho", "9988-8889", "Los Hermanos", "preco"), "99.0");		
		assertEquals(sistema.getInfoItem("katiau", "9912-3456", "War", "nome"), "War");
		assertEquals(sistema.getInfoItem("katiau", "9912-3456", "War", "preco"), "120.0");		

	}
	
	@Test
	public void testPesquisarDetalhesItens() {
		assertEquals(sistema.pesquisarDetalhesItem("Arizinho", "9900-6660", "X-men"), "FILME: X-men, R$ 29.99, Nao emprestado, 120 min, DEZESSEIS_ANOS, Acao, 2002");
		assertEquals(sistema.pesquisarDetalhesItem("Arizinho", "9900-6660", "The Walking Dead"), "SERIE: The Walking Dead, R$ 25.5, Nao emprestado, 160 min, DOZE_ANOS, Suspense, Temporada 2");
		assertEquals(sistema.pesquisarDetalhesItem("Arizinho", "9900-6660", "RBD"), "SHOW: RBD, R$ 45.99, Nao emprestado, 90 min, DOZE_ANOS, REBELDES, 15 faixas");
		assertEquals(sistema.pesquisarDetalhesItem("Arizinho", "9900-6660", "damas"), "JOGO DE TABULEIRO: damas, R$ 0.99, Nao emprestado, COMPLETO");
		assertEquals(sistema.pesquisarDetalhesItem("Arizinho", "9900-6660", "Mario bros"), "JOGO ELETRONICO: Mario bros, R$ 1.25, Nao emprestado, NINTENDO");
		
		assertEquals(sistema.pesquisarDetalhesItem("zezinho", "9988-8889", "Brasileirinhas"), "FILME: Brasileirinhas, R$ 69.0, Nao emprestado, 60 min, DEZOITO_ANOS, EROTICO, 2013");
		assertEquals(sistema.pesquisarDetalhesItem("zezinho", "9988-8889", "Vikings"), "SERIE: Vikings, R$ 99.0, Nao emprestado, 120 min, DOZE_ANOS, Suspense, Temporada 3");
		assertEquals(sistema.pesquisarDetalhesItem("zezinho", "9988-8889", "Los Hermanos"), "SHOW: Los Hermanos, R$ 99.0, Nao emprestado, 90 min, LIVRE, Losers manos, 15 faixas");
		assertEquals(sistema.pesquisarDetalhesItem("zezinho", "9988-8889", "Django"), "JOGO DE TABULEIRO: Django, R$ 24.0, Nao emprestado, COMPLETO");
		assertEquals(sistema.pesquisarDetalhesItem("zezinho", "9988-8889", "sonic"), "JOGO ELETRONICO: sonic, R$ 1.0, Nao emprestado, MEGA DRIVE");
		
	}
	
	@Test
	public void testListarItensOrdenadosPorNome() {
		assertEquals(sistema.listarItensOrdenadosPorNome(), "JOGO ELETRONICO: Bomba Patch, R$ 1.0, Nao emprestado, PS2|FILME: Brasileirinhas, R$ 69.0, Nao emprestado, 60 min, DEZOITO_ANOS,"
				+ " EROTICO, 2013|JOGO DE TABULEIRO: Django, R$ 24.0, Nao emprestado, COMPLETO|SERIE: Game of Thrones, R$ 35.0, Nao emprestado, 180 min, DEZESSEIS_ANOS, Suspense, Temporada 6|"
				+ "SHOW: LS, R$ 99.0, Nao emprestado, 90 min, DEZ_ANOS, Luan Santana, 15 faixas|SHOW: Los Hermanos, R$ 99.0, Nao emprestado, 90 min, LIVRE, Losers manos, 15 faixas|"
				+ "JOGO ELETRONICO: Mario bros, R$ 1.25, Nao emprestado, NINTENDO|SERIE: Mr Robot, R$ 86.0, Nao emprestado, 160 min, DEZESSEIS_ANOS, Drama, Temporada 2|"
				+ "FILME: Pirata dos caribes, R$ 50.0, Nao emprestado, 120 min, DEZESSEIS_ANOS, Acao, 2015|SHOW: RBD, R$ 45.99, Nao emprestado, 90 min, DOZE_ANOS, REBELDES, 15 faixas|"
				+ "SHOW: Ramones, R$ 10.0, Nao emprestado, 60 min, DEZ_ANOS, Ramonetmal, 5 faixas|FILME: Simpsons XXX, R$ 50.0, Nao emprestado, 120 min, DEZOITO_ANOS, EROTICO, 2000|"
				+ "SERIE: The Walking Dead, R$ 25.5, Nao emprestado, 160 min, DOZE_ANOS, Suspense, Temporada 2|SERIE: Vikings, R$ 99.0, Nao emprestado, 120 min, DOZE_ANOS, Suspense, Temporada 3|"
				+ "JOGO DE TABULEIRO: War, R$ 120.0, Nao emprestado, COMPLETO|FILME: X-men, R$ 29.99, Nao emprestado, 120 min, DEZESSEIS_ANOS, Acao, 2002|JOGO DE TABULEIRO: damas, R$ 0.99, Nao emprestado, COMPLETO|"
				+ "JOGO ELETRONICO: mario world, R$ 1.0, Nao emprestado, NINTENDO|JOGO ELETRONICO: sonic, R$ 1.0, Nao emprestado, MEGA DRIVE|JOGO DE TABULEIRO: xadrez, R$ 100.0, Nao emprestado, COMPLETO|");
	}


	@Test
	public void testListarItensOrdenadosPorValor() {
		assertEquals(sistema.listarItensOrdenadosPorValor(),"JOGO DE TABULEIRO: damas, "
				+ "R$ 0.99, Nao emprestado, COMPLETO|JOGO ELETRONICO: mario world, R$ 1.0,"
				+ " Nao emprestado, NINTENDO|JOGO ELETRONICO: Bomba Patch, R$ 1.0, Nao empr"
				+ "estado, PS2|JOGO ELETRONICO: sonic, R$ 1.0, Nao emprestado, MEGA DRIVE|J"
				+ "OGO ELETRONICO: Mario bros, R$ 1.25, Nao emprestado, NINTENDO|SHOW: Ramo"
				+ "nes, R$ 10.0, Nao emprestado, 60 min, DEZ_ANOS, Ramonetmal, 5 faixas|JOGO"
				+ " DE TABULEIRO: Django, R$ 24.0, Nao emprestado, COMPLETO|SERIE: The Walk"
				+ "ing Dead, R$ 25.5, Nao emprestado, 160 min, DOZE_ANOS, Suspense, Temporada"
				+ " 2|FILME: X-men, R$ 29.99, Nao emprestado, 120 min, DEZESSEIS_ANOS, Acao,"
				+ " 2002|SERIE: Game of Thrones, R$ 35.0, Nao emprestado, 180 min, DEZESSEIS_"
				+ "ANOS, Suspense, Temporada 6|SHOW: RBD, R$ 45.99, Nao emprestado, 90 min, "
				+ "DOZE_ANOS, REBELDES, 15 faixas|FILME: Pirata dos caribes, R$ 50.0, Nao e"
				+ "mprestado, 120 min, DEZESSEIS_ANOS, Acao, 2015|FILME: Simpsons XXX, R$ 50."
				+ "0, Nao emprestado, 120 min, DEZOITO_ANOS, EROTICO, 2000|FILME: Brasileir"
				+ "inhas, R$ 69.0, Nao emprestado, 60 min, DEZOITO_ANOS, EROTICO, 2013|SERIE:"
				+ " Mr Robot, R$ 86.0, Nao emprestado, 160 min, DEZESSEIS_ANOS, Drama, Tempo"
				+ "rada 2|SHOW: LS, R$ 99.0, Nao emprestado, 90 min, DEZ_ANOS, Luan Santana,"
				+ " 15 faixas|SERIE: Vikings, R$ 99.0, Nao emprestado, 120 min, DOZE_ANOS, S"
				+ "uspense, Temporada 3|SHOW: Los Hermanos, R$ 99.0, Nao emprestado, 90 min,"
				+ " LIVRE, Losers manos, 15 faixas|JOGO DE TABULEIRO: xadrez, R$ 100.0, Nao "
				+ "emprestado, COMPLETO|JOGO DE TABULEIRO: War, R$ 120.0, Nao emprestado, CO"
				+ "MPLETO|");
	}
	
	@Test
	(expected = NullPointerException.class)
	public void testUsuariosInexistentesRemoverUsuario(){
		sistema.removerUsuario("No one", "9900-6660");
		sistema.removerUsuario("Arizinho", "0000-6660");
		sistema.removerUsuario("Ramones", "9999999");
		
	}

}
