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
		sistema.cadastrarUsuario("Joaozinho", "9191-9191", "joaozinho@hotmail.com");
		sistema.cadastrarUsuario("Thurzinho","2400-9999","thurzinho@hotmail.com");
		sistema.cadastrarUsuario("PV","1000-1000","pv@hotmail.com");
		sistema.cadastrarUsuario("Vinicin", "5557-7775", "vinicin@hotmail.com");
		sistema.cadastrarUsuario("Motinha", "4321-1234", "mota@hotmail.com");
		sistema.cadastrarUsuario("Shevchenko", "7777-7777", "shevgoleador@gmail.com");
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
		// Adicionando para Joaozinho 9191-9191
		sistema.cadastrarJogoTabuleiro("Joaozinho","9191-9191", "War", 120.00);
		sistema.cadastrarJogoTabuleiro("Joaozinho", "9191-9191", "damas", 0.99);
		// Adicionando para Thurzinho 2424-2424
		sistema.cadastrarBluRayShow("Thurzinho", "2400-9999", "PV K.O", 99.00, 90, 8, "PV", "DEZOITO_ANOS");
		// Adicionando para Vinicin 5557-7775
		sistema.cadastrarEletronico("Vinicin", "5557-7775", "Street Fighter", 100.00, "PC");
		// Adicionando para Motinha 4321-1234
		sistema.cadastrarBluRayFilme("Motinha", "4321-1234", "A arte de codar", 1050.00, 185, "Erotico", "DEZOITO_ANOS", 2017);
		sistema.cadastrarJogoTabuleiro("Motinha", "4321-1234", "Jogo da vida", 100.00);
		// Adicionando para Shevchenko 7777-7777
		sistema.cadastrarBluRayFilme("Shevchenko", "7777-7777", "Autobiografia de Shevchenko", 1000.00, 320, "Documentario", "DEZ_ANOS", 2005);
		
		// Registrando emprestimos e devolucoes
		sistema.registrarEmprestimo("Arizinho", "9900-6660", "zezinho", "9988-8889", "RBD", "01/01/2017", 7);
		sistema.registrarEmprestimo("Arizinho", "9900-6660", "zezinho", "9988-8889", "The Walking Dead", "01/01/2017", 7);
		sistema.registrarEmprestimo("Arizinho", "9900-6660", "zezinho", "9988-8889", "damas", "01/01/2017", 7);	
		sistema.registrarEmprestimo("Arizinho", "9900-6660", "zezinho", "9988-8889", "Mario bros", "01/01/2017", 7);
		sistema.devolverItem("Arizinho", "9900-6660", "zezinho", "9988-8889", "RBD","01/01/2017", "03/01/2017");
		sistema.devolverItem("Arizinho","9900-6660","zezinho","9988-8889","damas","01/01/2017","03/01/2017");
		sistema.registrarEmprestimo("Arizinho", "9900-6660", "katiau", "9912-3456", "RBD", "05/01/2017", 7);	
		sistema.devolverItem("Arizinho", "9900-6660", "katiau", "9912-3456", "RBD","01/01/2017", "08/01/2017");
		sistema.registrarEmprestimo("Arizinho", "9900-6660","Ramones", "9955-2222", "RBD", "09/01/2017", 7);	
		sistema.devolverItem("Arizinho", "9900-6660", "Ramones", "9955-2222", "RBD","01/01/2017", "11/01/2017");
		sistema.registrarEmprestimo("zezinho","9988-8889" , "katiau", "9912-3456", "Brasileirinhas", "01/01/2017", 7);
		sistema.registrarEmprestimo("zezinho","9988-8889" , "katiau", "9912-3456", "Vikings", "01/01/2017", 7);
		sistema.registrarEmprestimo("zezinho","9988-8889" , "katiau", "9912-3456", "Los Hermanos", "01/01/2017", 7);
		sistema.registrarEmprestimo("zezinho","9988-8889" , "katiau", "9912-3456", "Django", "01/01/2017", 7);
		sistema.registrarEmprestimo("zezinho","9988-8889" , "katiau", "9912-3456", "sonic", "01/01/2017", 7);
		sistema.registrarEmprestimo("katiau","9912-3456" , "Ramones", "9955-2222", "Mr Robot", "01/01/2017", 7);
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
		assertEquals(sistema.pesquisarDetalhesItem("Arizinho", "9900-6660", "The Walking Dead"), "SERIE: The Walking Dead, R$ 25.5, Emprestado, 160 min, DOZE_ANOS, Suspense, Temporada 2");
		assertEquals(sistema.pesquisarDetalhesItem("Arizinho", "9900-6660", "RBD"), "SHOW: RBD, R$ 45.99, Nao emprestado, 90 min, DOZE_ANOS, REBELDES, 15 faixas");
		assertEquals(sistema.pesquisarDetalhesItem("Arizinho", "9900-6660", "damas"), "JOGO DE TABULEIRO: damas, R$ 0.99, Nao emprestado, COMPLETO");
		assertEquals(sistema.pesquisarDetalhesItem("Arizinho", "9900-6660", "Mario bros"), "JOGO ELETRONICO: Mario bros, R$ 1.25, Emprestado, NINTENDO");		
		assertEquals(sistema.pesquisarDetalhesItem("zezinho", "9988-8889", "Brasileirinhas"), "FILME: Brasileirinhas, R$ 69.0, Emprestado, 60 min, DEZOITO_ANOS, EROTICO, 2013");
		assertEquals(sistema.pesquisarDetalhesItem("zezinho", "9988-8889", "Vikings"), "SERIE: Vikings, R$ 99.0, Emprestado, 120 min, DOZE_ANOS, Suspense, Temporada 3");
		assertEquals(sistema.pesquisarDetalhesItem("zezinho", "9988-8889", "Los Hermanos"), "SHOW: Los Hermanos, R$ 99.0, Emprestado, 90 min, LIVRE, Losers manos, 15 faixas");
		assertEquals(sistema.pesquisarDetalhesItem("zezinho", "9988-8889", "Django"), "JOGO DE TABULEIRO: Django, R$ 24.0, Emprestado, COMPLETO");
		assertEquals(sistema.pesquisarDetalhesItem("zezinho", "9988-8889", "sonic"), "JOGO ELETRONICO: sonic, R$ 1.0, Emprestado, MEGA DRIVE");
		
	}
	
	@Test
	public void testListarItensOrdenadosPorNome() {
		assertEquals("FILME: A arte de codar, R$ 1050.0, Nao emprestado, 185 min, DEZOITO_ANOS, Erotico, 2017|"
				+ "FILME: Autobiografia de Shevchenko, R$ 1000.0, Nao emprestado, 320 min, DEZ_ANOS, Documentario, 2005|"
				+ "JOGO ELETRONICO: Bomba Patch, R$ 1.0, Nao emprestado, PS2|"
				+ "FILME: Brasileirinhas, R$ 69.0, Emprestado, 60 min, DEZOITO_ANOS, EROTICO, 2013|"
				+ "JOGO DE TABULEIRO: Django, R$ 24.0, Emprestado, COMPLETO|"
				+ "SERIE: Game of Thrones, R$ 35.0, Nao emprestado, 180 min, DEZESSEIS_ANOS, Suspense, Temporada 6|"
				+ "JOGO DE TABULEIRO: Jogo da vida, R$ 100.0, Nao emprestado, COMPLETO|"
				+ "SHOW: LS, R$ 99.0, Nao emprestado, 90 min, DEZ_ANOS, Luan Santana, 15 faixas|"
				+ "SHOW: Los Hermanos, R$ 99.0, Emprestado, 90 min, LIVRE, Losers manos, 15 faixas|"
				+ "JOGO ELETRONICO: Mario bros, R$ 1.25, Emprestado, NINTENDO|"
				+ "SERIE: Mr Robot, R$ 86.0, Emprestado, 160 min, DEZESSEIS_ANOS, Drama, Temporada 2|"
				+ "SHOW: PV K.O, R$ 99.0, Nao emprestado, 90 min, DEZOITO_ANOS, PV, 8 faixas|"
				+ "FILME: Pirata dos caribes, R$ 50.0, Nao emprestado, 120 min, DEZESSEIS_ANOS, Acao, 2015|"
				+ "SHOW: RBD, R$ 45.99, Nao emprestado, 90 min, DOZE_ANOS, REBELDES, 15 faixas|"
				+ "SHOW: Ramones, R$ 10.0, Nao emprestado, 60 min, DEZ_ANOS, Ramonetmal, 5 faixas|"
				+ "FILME: Simpsons XXX, R$ 50.0, Nao emprestado, 120 min, DEZOITO_ANOS, EROTICO, 2000|"
				+ "JOGO ELETRONICO: Street Fighter, R$ 100.0, Nao emprestado, PC|"
				+ "SERIE: The Walking Dead, R$ 25.5, Emprestado, 160 min, DOZE_ANOS, Suspense, Temporada 2|"
				+ "SERIE: Vikings, R$ 99.0, Emprestado, 120 min, DOZE_ANOS, Suspense, Temporada 3|"
				+ "JOGO DE TABULEIRO: War, R$ 120.0, Nao emprestado, COMPLETO|JOGO DE TABULEIRO: War, R$ 120.0, Nao emprestado, COMPLETO|"
				+ "FILME: X-men, R$ 29.99, Nao emprestado, 120 min, DEZESSEIS_ANOS, Acao, 2002|"
				+ "JOGO DE TABULEIRO: damas, R$ 0.99, Nao emprestado, COMPLETO|"
				+ "JOGO DE TABULEIRO: damas, R$ 0.99, Nao emprestado, COMPLETO|"
				+ "JOGO ELETRONICO: mario world, R$ 1.0, Nao emprestado, NINTENDO|"
				+ "JOGO ELETRONICO: sonic, R$ 1.0, Emprestado, MEGA DRIVE|"
				+ "JOGO DE TABULEIRO: xadrez, R$ 100.0, Nao emprestado, COMPLETO|",sistema.listarItensOrdenadosPorNome());
	}


	@Test
	public void testListarItensOrdenadosPorValor() {
		assertEquals("JOGO DE TABULEIRO: damas, R$ 0.99, Nao emprestado, COMPLETO|"
				+ "JOGO DE TABULEIRO: damas, R$ 0.99, Nao emprestado, COMPLETO|"
				+ "JOGO ELETRONICO: mario world, R$ 1.0, Nao emprestado, NINTENDO|"
				+ "JOGO ELETRONICO: Bomba Patch, R$ 1.0, Nao emprestado, PS2|"
				+ "JOGO ELETRONICO: sonic, R$ 1.0, Emprestado, MEGA DRIVE|"
				+ "JOGO ELETRONICO: Mario bros, R$ 1.25, Emprestado, NINTENDO|"
				+ "SHOW: Ramones, R$ 10.0, Nao emprestado, 60 min, DEZ_ANOS, Ramonetmal, 5 faixas|"
				+ "JOGO DE TABULEIRO: Django, R$ 24.0, Emprestado, COMPLETO|"
				+ "SERIE: The Walking Dead, R$ 25.5, Emprestado, 160 min, DOZE_ANOS, Suspense, Temporada 2|"
				+ "FILME: X-men, R$ 29.99, Nao emprestado, 120 min, DEZESSEIS_ANOS, Acao, 2002|"
				+ "SERIE: Game of Thrones, R$ 35.0, Nao emprestado, 180 min, DEZESSEIS_ANOS, Suspense, Temporada 6|"
				+ "SHOW: RBD, R$ 45.99, Nao emprestado, 90 min, DOZE_ANOS, REBELDES, 15 faixas|"
				+ "FILME: Pirata dos caribes, R$ 50.0, Nao emprestado, 120 min, DEZESSEIS_ANOS, Acao, 2015|"
				+ "FILME: Simpsons XXX, R$ 50.0, Nao emprestado, 120 min, DEZOITO_ANOS, EROTICO, 2000|"
				+ "FILME: Brasileirinhas, R$ 69.0, Emprestado, 60 min, DEZOITO_ANOS, EROTICO, 2013|"
				+ "SERIE: Mr Robot, R$ 86.0, Emprestado, 160 min, DEZESSEIS_ANOS, Drama, Temporada 2|"
				+ "SHOW: PV K.O, R$ 99.0, Nao emprestado, 90 min, DEZOITO_ANOS, PV, 8 faixas|"
				+ "SHOW: LS, R$ 99.0, Nao emprestado, 90 min, DEZ_ANOS, Luan Santana, 15 faixas|"
				+ "SERIE: Vikings, R$ 99.0, Emprestado, 120 min, DOZE_ANOS, Suspense, Temporada 3|"
				+ "SHOW: Los Hermanos, R$ 99.0, Emprestado, 90 min, LIVRE, Losers manos, 15 faixas|"
				+ "JOGO ELETRONICO: Street Fighter, R$ 100.0, Nao emprestado, PC|"
				+ "JOGO DE TABULEIRO: Jogo da vida, R$ 100.0, Nao emprestado, COMPLETO|"
				+ "JOGO DE TABULEIRO: xadrez, R$ 100.0, Nao emprestado, COMPLETO|"
				+ "JOGO DE TABULEIRO: War, R$ 120.0, Nao emprestado, COMPLETO|"
				+ "JOGO DE TABULEIRO: War, R$ 120.0, Nao emprestado, COMPLETO|"
				+ "FILME: Autobiografia de Shevchenko, R$ 1000.0, Nao emprestado, 320 min, DEZ_ANOS, Documentario, 2005|"
				+ "FILME: A arte de codar, R$ 1050.0, Nao emprestado, 185 min, DEZOITO_ANOS, Erotico, 2017|"
				,sistema.listarItensOrdenadosPorValor());
			
	}
	
	@Test
	(expected = NullPointerException.class)
	public void testUsuariosInexistentesRemoverUsuario(){
		sistema.removerUsuario("No one", "9900-6660");
		sistema.removerUsuario("Arizinho", "0000-6660");
		sistema.removerUsuario("Ramones", "9999999");
		
	}
	
	@Test
	public void testListarTop10Itens(){
		assertEquals("1) 3 emprestimos - SHOW: RBD, R$ 45.99, Nao emprestado, 90 min, DOZE_ANOS, REBELDES, 15 faixas|2) 1 emprestimos - SERIE: Mr Robot, R$ 86.0, Emprestado, 160 min, DEZESSEIS_ANOS, Drama, Temporada 2|3) 1 emprestimos - SERIE: Vikings, R$ 99.0, Emprestado, 120 min, DOZE_ANOS, Suspense, Temporada 3|4) 1 emprestimos - JOGO ELETRONICO: sonic, R$ 1.0, Emprestado, MEGA DRIVE|5) 1 emprestimos - FILME: Brasileirinhas, R$ 69.0, Emprestado, 60 min, DEZOITO_ANOS, EROTICO, 2013|6) 1 emprestimos - JOGO DE TABULEIRO: Django, R$ 24.0, Emprestado, COMPLETO|7) 1 emprestimos - SHOW: Los Hermanos, R$ 99.0, Emprestado, 90 min, LIVRE, Losers manos, 15 faixas|8) 1 emprestimos - JOGO ELETRONICO: Mario bros, R$ 1.25, Emprestado, NINTENDO|9) 1 emprestimos - SERIE: The Walking Dead, R$ 25.5, Emprestado, 160 min, DOZE_ANOS, Suspense, Temporada 2|10) 1 emprestimos - JOGO DE TABULEIRO: damas, R$ 0.99, Nao emprestado, COMPLETO|",sistema.listarTop10Itens());
	}
	
	@Test
	public void testListarTop10(){
		assertEquals("1: Motinha - Reputacao: 57,50|" //Teste para listarTop10MelhoresUsuarios
				+ "2: Shevchenko - Reputacao: 50,00|"
				+ "3: zezinho - Reputacao: 46,15|"
				+ "4: katiau - Reputacao: 24,25|"
				+ "5: Arizinho - Reputacao: 21,76|"
				+ "6: Ramones - Reputacao: 16,55|"
				+ "7: Joaozinho - Reputacao: 6,05|"
				+ "8: Vinicin - Reputacao: 5,00|"
				+ "9: Thurzinho - Reputacao: 4,95|"
				+ "10: PV - Reputacao: 0,00|",sistema.listarTop10MelhoresUsuarios());
		
		assertEquals("1: PV - Reputacao: 0,00|"//Teste para listarTop10PioresUsuarios
				+ "2: Thurzinho - Reputacao: 4,95|"
				+ "3: Vinicin - Reputacao: 5,00|"
				+ "4: Joaozinho - Reputacao: 6,05|"
				+ "5: Ramones - Reputacao: 16,55|"
				+ "6: Arizinho - Reputacao: 21,76|"
				+ "7: katiau - Reputacao: 24,25|"
				+ "8: zezinho - Reputacao: 46,15|"
				+ "9: Shevchenko - Reputacao: 50,00|"
				+ "10: Motinha - Reputacao: 57,50|",sistema.listarTop10PioresUsuarios());
	}
	
	@Test
	public void testListarCaloteiros(){
		assertEquals("Lista de usuarios com reputacao negativa: ",sistema.listarCaloteiros());
		sistema.cadastrarUsuario("Reymar", "9999-8383", "neymar@gmail.com");
		sistema.registrarEmprestimo("Arizinho", "9900-6660", "Reymar","9999-8383", "RBD", "01/01/2017", 2);
		sistema.devolverItem("Arizinho", "9900-6660", "Reymar", "9999-8383", "RBD", "01/01/2017", "03/03/2017");
		assertEquals("Lista de usuarios com reputacao negativa: Reymar, neymar@gmail.com, 9999-8383|",sistema.listarCaloteiros());
		
	}
	
	@Test
	public void testListarEmprestimosItem(){
		assertEquals("Nenhum emprestimos associados ao item",sistema.listarEmprestimosItem("PV K.O"));
		sistema.registrarEmprestimo("Thurzinho", "2400-9999", "zezinho","9988-8889", "PV K.O", "01/01/2017", 7);
		sistema.devolverItem("Thurzinho", "2400-9999", "zezinho","9988-8889", "PV K.O", "01/01/2017", "03/01/2017");
		sistema.registrarEmprestimo("Thurzinho", "2400-9999", "Ramones","9955-2222", "PV K.O", "04/01/2017", 7);
		sistema.devolverItem("Thurzinho", "2400-9999", "Ramones","9955-2222", "PV K.O", "04/01/2017", "05/01/2017");
		assertEquals("Emprestimos associados ao item: EMPRESTIMO - De: Thurzinho, Para: zezinho, PV K.O, 01/01/2017, 7 dias, ENTREGA: 03/01/2017|EMPRESTIMO - De: Thurzinho, Para: Ramones, PV K.O, 04/01/2017, 7 dias, ENTREGA: 05/01/2017|",sistema.listarEmprestimosItem("PV K.O"));
	}
	
	@Test
	public void testListarItensEmprestados(){
		assertEquals("Dono do item: zezinho, Nome do item emprestado: Brasileirinhas|Dono do item: zezinho, Nome do item emprestado: Django|Dono do item: zezinho, Nome do item emprestado: Los Hermanos|Dono do item: Arizinho, Nome do item emprestado: Mario bros|Dono do item: katiau, Nome do item emprestado: Mr Robot|Dono do item: Arizinho, Nome do item emprestado: The Walking Dead|Dono do item: zezinho, Nome do item emprestado: Vikings|Dono do item: zezinho, Nome do item emprestado: sonic|",sistema.listarItensEmprestados());
	}
	
	@Test
	public void testListarItensNaoEmprestados(){
		assertEquals("FILME: A arte de codar, R$ 1050.0, Nao emprestado, 185 min, DEZOITO_ANOS, Erotico, 2017|FILME: Autobiografia de Shevchenko, R$ 1000.0, Nao emprestado, 320 min, DEZ_ANOS, Documentario, 2005|JOGO ELETRONICO: Bomba Patch, R$ 1.0, Nao emprestado, PS2|SERIE: Game of Thrones, R$ 35.0, Nao emprestado, 180 min, DEZESSEIS_ANOS, Suspense, Temporada 6|JOGO DE TABULEIRO: Jogo da vida, R$ 100.0, Nao emprestado, COMPLETO|SHOW: LS, R$ 99.0, Nao emprestado, 90 min, DEZ_ANOS, Luan Santana, 15 faixas|SHOW: PV K.O, R$ 99.0, Nao emprestado, 90 min, DEZOITO_ANOS, PV, 8 faixas|FILME: Pirata dos caribes, R$ 50.0, Nao emprestado, 120 min, DEZESSEIS_ANOS, Acao, 2015|SHOW: RBD, R$ 45.99, Nao emprestado, 90 min, DOZE_ANOS, REBELDES, 15 faixas|SHOW: Ramones, R$ 10.0, Nao emprestado, 60 min, DEZ_ANOS, Ramonetmal, 5 faixas|FILME: Simpsons XXX, R$ 50.0, Nao emprestado, 120 min, DEZOITO_ANOS, EROTICO, 2000|JOGO ELETRONICO: Street Fighter, R$ 100.0, Nao emprestado, PC|JOGO DE TABULEIRO: War, R$ 120.0, Nao emprestado, COMPLETO|JOGO DE TABULEIRO: War, R$ 120.0, Nao emprestado, COMPLETO|FILME: X-men, R$ 29.99, Nao emprestado, 120 min, DEZESSEIS_ANOS, Acao, 2002|JOGO DE TABULEIRO: damas, R$ 0.99, Nao emprestado, COMPLETO|JOGO DE TABULEIRO: damas, R$ 0.99, Nao emprestado, COMPLETO|JOGO ELETRONICO: mario world, R$ 1.0, Nao emprestado, NINTENDO|JOGO DE TABULEIRO: xadrez, R$ 100.0, Nao emprestado, COMPLETO|",sistema.listarItensNaoEmprestados());
	}
	
	

}
